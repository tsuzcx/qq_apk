package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
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
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("copyForwardFile:error. filePath[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]");
      QLog.i("DatalineForwardHandler", 1, ((StringBuilder)localObject1).toString());
      return paramString;
    }
    Object localObject1 = FileManagerUtil.a(paramString);
    long l = FileUtils.getFileSizes(paramString);
    if (l > 5242880L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("copyForwardFile:error. fileSize[");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("]");
      QLog.i("DatalineForwardHandler", 1, ((StringBuilder)localObject1).toString());
      return paramString;
    }
    if ((float)l > FileUtils.getAvailableExternalMemorySize())
    {
      QLog.i("DatalineForwardHandler", 1, "copyForwardFile:error. file space not enough");
      return paramString;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FMSettings.a().getDefaultRecvPath());
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = FileManagerUtil.b(((StringBuilder)localObject2).toString());
    localObject1 = paramString;
    if (FileUtils.copyFile(paramString, (String)localObject2)) {
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {
      return;
    }
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
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
      b(this.jdField_a_of_type_AndroidContentContext.getString(2131693716));
      return;
    }
    if (paramIntent.size() > 50)
    {
      b(this.jdField_a_of_type_AndroidContentContext.getString(2131693716));
      return;
    }
    a(paramIntent);
  }
  
  protected List<Uri> a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    paramIntent = paramIntent.getAction();
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.equals("android.intent.action.SEND"))
    {
      localObject = (Uri)((Bundle)localObject).get("android.intent.extra.STREAM");
      paramIntent = localArrayList;
      if (localObject != null)
      {
        localArrayList.add(localObject);
        return localArrayList;
      }
    }
    else
    {
      paramIntent = (ArrayList)((Bundle)localObject).get("android.intent.extra.STREAM");
    }
    return paramIntent;
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
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = a((Uri)paramList.next());
        if (FileUtils.fileExistsAndNotEmpty(str)) {
          localArrayList.add(str);
        }
      }
      b(localArrayList);
    }
  }
  
  protected void a(List<String> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (FileUtils.fileExistsAndNotEmpty(str)) {
          localArrayList.add(str);
        }
      }
      ThreadManagerV2.executeOnSubThread(new DatalineForwardHandler.SendFileTask(this, localArrayList, paramInt));
    }
  }
  
  protected void b(String paramString)
  {
    DatalineForwardHandler.2 local2 = new DatalineForwardHandler.2(this);
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    DialogUtil.a(localContext, 233, localContext.getString(2131719632), paramString, 2131693700, 2131693700, local2, null).show();
  }
  
  protected void b(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (FileUtils.fileExistsAndNotEmpty(str)) {
          localArrayList.add(str);
        }
      }
      DatalineDeviceChooseModel.a(localArrayList).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DatalineForwardHandler.1(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineForwardHandler
 * JD-Core Version:    0.7.0.1
 */