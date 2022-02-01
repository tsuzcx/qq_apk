package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class DatalineOldForwardHandler
  extends DatalineForwardHandler
{
  private Activity c;
  private ForwardBaseOption d;
  
  public DatalineOldForwardHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.c = ((Activity)paramContext);
  }
  
  private Intent a()
  {
    return this.c.getIntent();
  }
  
  private void c(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i == -1) {
      return;
    }
    if (paramIntent.getBooleanExtra("sendMultiple", false))
    {
      if (g(paramIntent)) {}
    }
    else
    {
      if (h(paramIntent)) {
        return;
      }
      switch (i)
      {
      default: 
        StatisticAssist.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), "dl_forwardin_other");
        return;
      case 102: 
        d(paramIntent);
        return;
      case 101: 
        if (!f(paramIntent)) {}
        break;
      case 100: 
        if (e(paramIntent)) {
          break;
        }
      }
    }
  }
  
  private void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("dataline_forward_text");
    if ((paramIntent != null) && (paramIntent.length() > 0))
    {
      if (Patterns.d.matcher(paramIntent).find()) {
        StatisticAssist.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), "dl_forwardin_link");
      } else {
        StatisticAssist.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), "dl_forwardin_text");
      }
      a(paramIntent);
    }
  }
  
  private boolean e(Intent paramIntent)
  {
    StatisticAssist.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), "dl_forwardin_file");
    ArrayList localArrayList = new ArrayList();
    String str = paramIntent.getStringExtra("dataline_forward_path");
    if ((str != null) && (!str.equals("")))
    {
      String[] arrayOfString = str.split(";");
      localArrayList.clear();
      int i = 0;
      while (i < arrayOfString.length)
      {
        try
        {
          str = URLDecoder.decode(arrayOfString[i], "UTF-8");
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          StringBuilder localStringBuilder;
          label188:
          break label188;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          label89:
          break label89;
        }
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str))
        {
          if ((!str.startsWith("http://")) && (!str.startsWith("https://"))) {
            localArrayList.add(str);
          } else {
            a(str);
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("shareFromMigSdk|file path invalid. path=");
          localStringBuilder.append(str);
          QLog.e("qqdataline", 2, localStringBuilder.toString());
        }
        i += 1;
        continue;
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("shareFromMigSdk|decode exp. imageUrls[i]=");
          paramIntent.append(arrayOfString[i]);
          QLog.e("qqdataline", 2, paramIntent.toString());
        }
        return false;
      }
      if (!localArrayList.isEmpty())
      {
        b(localArrayList);
        if (paramIntent.getBooleanExtra("isMigSdkShare", false))
        {
          ReportController.b(this.a, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
          }
        }
      }
      return true;
    }
    else
    {
      b(this.b.getString(2131891339));
      return true;
    }
  }
  
  private boolean f(Intent paramIntent)
  {
    StatisticAssist.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), "dl_forwardin_image");
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramIntent.getStringExtra("dataline_forward_path");
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleForwardRequest forward image, extras: ");
      ((StringBuilder)localObject).append(paramIntent.getExtras().toString());
      QLog.e("DatalineOldForwardHandler", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    String[] arrayOfString = ((String)localObject).split(";");
    localArrayList.clear();
    int i = 0;
    while (i < arrayOfString.length)
    {
      try
      {
        localObject = URLDecoder.decode(arrayOfString[i], "UTF-8");
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        StringBuilder localStringBuilder;
        label256:
        break label256;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label116:
        break label116;
      }
      localObject = arrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((!((String)localObject).startsWith("http://")) && (!((String)localObject).startsWith("https://")))
        {
          localArrayList.add(localObject);
        }
        else
        {
          a((String)localObject);
          ReportController.b(this.a, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("gotoQfavShareMsg|file path invalid. path=");
        localStringBuilder.append((String)localObject);
        QLog.e("qqdataline", 2, localStringBuilder.toString());
      }
      i += 1;
      continue;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("shareFromMigSdk|decode exp. imageUrls[i]=");
        paramIntent.append(arrayOfString[i]);
        QLog.e("qqdataline", 2, paramIntent.toString());
      }
      return false;
    }
    if (!localArrayList.isEmpty())
    {
      a(localArrayList, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
      if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
        if (localArrayList.size() > 1)
        {
          ReportController.b(this.a, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
            return true;
          }
        }
        else if (localArrayList.size() == 1)
        {
          ReportController.b(this.a, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
          }
        }
      }
    }
    return true;
  }
  
  private boolean g(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
    Object localObject4;
    if (localArrayList == null)
    {
      localObject4 = paramIntent.getExtras();
      localObject3 = null;
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((Bundle)localObject4).getParcelableArrayList("fileinfo_array");
        localObject1 = localObject3;
        if (localObject4 == null) {}
      }
    }
    try
    {
      localObject1 = (ArrayList)localObject4;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 == null)
    {
      b(this.b.getString(2131891339));
      return false;
    }
    localObject3 = new ArrayList();
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (ForwardFileInfo)((Iterator)localObject1).next();
      if (FileUtils.fileExistsAndNotEmpty(((ForwardFileInfo)localObject4).d())) {
        ((List)localObject3).add(((ForwardFileInfo)localObject4).d());
      }
    }
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      a((List)localObject3, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
    }
    else
    {
      b(this.b.getString(2131891339));
      return false;
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        if ((localObject3 == null) || (((String)localObject3).equals("/"))) {
          ((Iterator)localObject1).remove();
        }
      }
      if (localArrayList.isEmpty())
      {
        b(this.b.getString(2131891339));
        return false;
      }
      a(localArrayList, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
    }
    return true;
  }
  
  private boolean h(Intent paramIntent)
  {
    return (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo") != null;
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.d = ForwardOptionBuilder.a(paramIntent, this.a, (Activity)this.b);
      paramIntent = new Bundle();
      paramIntent.putString("uin", AppConstants.DATALINE_PC_UIN);
      paramIntent.putInt("uintype", -1);
      this.d.a(ForwardAbility.ForwardAbilityType.g.intValue(), paramIntent);
      return;
    }
    c(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineOldForwardHandler
 * JD-Core Version:    0.7.0.1
 */