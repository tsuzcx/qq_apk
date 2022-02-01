package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatalineForwardHandler
{
  protected Context a;
  protected QQAppInterface a;
  private String a;
  
  public DatalineForwardHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private String a(Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramUri);
  }
  
  private String a(String paramString)
  {
    if (!FileUtils.b(paramString)) {
      QLog.i("DatalineForwardHandler", 1, "copyForwardFile:error. filePath[" + paramString + "]");
    }
    String str;
    do
    {
      return paramString;
      str = FileManagerUtil.a(paramString);
      long l = FileUtils.a(paramString);
      if (l > 5242880L)
      {
        QLog.i("DatalineForwardHandler", 1, "copyForwardFile:error. fileSize[" + l + "]");
        return paramString;
      }
      if ((float)l > FileUtils.c())
      {
        QLog.i("DatalineForwardHandler", 1, "copyForwardFile:error. file space not enough");
        return paramString;
      }
      str = FileManagerUtil.b(FMSettings.a().b() + str);
    } while (!FileUtils.d(paramString, str));
    return str;
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramIntent.getExtras();
    } while (localBundle == null);
    String str = paramIntent.getType();
    if ((str.startsWith("text")) && (!localBundle.containsKey("android.intent.extra.STREAM")))
    {
      QLog.i("DatalineForwardHandler", 1, "handleForwardFromShare: forward text.");
      a(localBundle.getString("android.intent.extra.TEXT"));
      return;
    }
    if (str.startsWith("message"))
    {
      QLog.i("DatalineForwardHandler", 1, "handleForwardFromShare: forward message text.");
      a(((SpannableString)localBundle.get("android.intent.extra.TEXT")).toString());
      return;
    }
    QLog.i("DatalineForwardHandler", 1, "handleForwardFromShare: forward file.");
    paramIntent = a(paramIntent);
    if (paramIntent.isEmpty())
    {
      b(this.jdField_a_of_type_AndroidContentContext.getString(2131693763));
      return;
    }
    if (paramIntent.size() > 50)
    {
      b(this.jdField_a_of_type_AndroidContentContext.getString(2131693763));
      return;
    }
    a(paramIntent);
  }
  
  protected List<Uri> a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    String str = paramIntent.getAction();
    paramIntent = new ArrayList();
    if (str.equals("android.intent.action.SEND"))
    {
      localObject = (Uri)((Bundle)localObject).get("android.intent.extra.STREAM");
      if (localObject != null) {
        paramIntent.add(localObject);
      }
      return paramIntent;
    }
    return (ArrayList)((Bundle)localObject).get("android.intent.extra.STREAM");
  }
  
  public void a(Intent paramIntent)
  {
    if (TextUtils.isEmpty(paramIntent.getType())) {
      return;
    }
    b(paramIntent);
  }
  
  protected void a(String paramString) {}
  
  protected void a(List<Uri> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = a((Uri)paramList.next());
      if (FileUtils.b(str)) {
        localArrayList.add(str);
      }
    }
    b(localArrayList);
  }
  
  protected void a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (FileUtils.b(str)) {
        localArrayList.add(str);
      }
    }
    ThreadManagerV2.executeOnSubThread(new DatalineForwardHandler.SendFileTask(this, localArrayList, paramInt));
  }
  
  protected void b(String paramString)
  {
    DatalineForwardHandler.2 local2 = new DatalineForwardHandler.2(this);
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 233, this.jdField_a_of_type_AndroidContentContext.getString(2131719900), paramString, 2131693747, 2131693747, local2, null).show();
  }
  
  protected void b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (FileUtils.b(str)) {
        localArrayList.add(str);
      }
    }
    DatalineDeviceChooseModel.a(localArrayList).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DatalineForwardHandler.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineForwardHandler
 * JD-Core Version:    0.7.0.1
 */