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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
  
  public DatalineOldForwardHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private Intent a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getIntent();
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool = false;
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_file");
    ArrayList localArrayList = new ArrayList();
    String str = paramIntent.getStringExtra("dataline_forward_path");
    if ((str == null) || (str.equals("")))
    {
      b(this.jdField_a_of_type_AndroidContentContext.getString(2131693811));
      bool = true;
    }
    for (;;)
    {
      return bool;
      String[] arrayOfString = str.split(";");
      localArrayList.clear();
      int i = 0;
      if (i < arrayOfString.length) {
        try
        {
          str = URLDecoder.decode(arrayOfString[i], "UTF-8");
          if (!TextUtils.isEmpty(str)) {
            if ((str.startsWith("http://")) || (str.startsWith("https://")))
            {
              a(str);
              i += 1;
            }
          }
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + arrayOfString[i]);
            return false;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Object localObject = arrayOfString[i];
            continue;
            localArrayList.add(localObject);
            continue;
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + localObject);
            }
          }
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      b(localArrayList);
      if (paramIntent.getBooleanExtra("isMigSdkShare", false))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
        }
      }
    }
    return true;
  }
  
  private void b(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i == -1) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramIntent.getBooleanExtra("sendMultiple", false)) {
              break;
            }
          } while (c(paramIntent));
          return;
        } while (d(paramIntent));
        switch (i)
        {
        default: 
          StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_other");
          return;
        }
      } while (b(paramIntent));
      return;
    } while (a(paramIntent));
    return;
    c(paramIntent);
  }
  
  private boolean b(Intent paramIntent)
  {
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_image");
    ArrayList localArrayList = new ArrayList();
    String str = paramIntent.getStringExtra("dataline_forward_path");
    if (str == null)
    {
      QLog.e("DatalineOldForwardHandler", 1, "handleForwardRequest forward image, extras: " + paramIntent.getExtras().toString());
      return false;
    }
    String[] arrayOfString = str.split(";");
    localArrayList.clear();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length) {
        try
        {
          str = URLDecoder.decode(arrayOfString[i], "UTF-8");
          if (!TextUtils.isEmpty(str)) {
            if ((str.startsWith("http://")) || (str.startsWith("https://")))
            {
              a(str);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
              }
              i += 1;
            }
          }
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + arrayOfString[i]);
          }
          return false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Object localObject = arrayOfString[i];
            continue;
            localArrayList.add(localObject);
            continue;
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject);
            }
          }
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      a(localArrayList, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
      if (paramIntent.getBooleanExtra("isMigSdkShare", false))
      {
        if (localArrayList.size() <= 1) {
          break label358;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
        }
      }
    }
    for (;;)
    {
      return true;
      label358:
      if (localArrayList.size() == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
        }
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("dataline_forward_text");
    if ((paramIntent != null) && (paramIntent.length() > 0))
    {
      if (!Patterns.d.matcher(paramIntent).find()) {
        break label60;
      }
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_link");
    }
    for (;;)
    {
      a(paramIntent);
      return;
      label60:
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "dl_forwardin_text");
    }
  }
  
  private boolean c(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
    Object localObject1;
    if (localArrayList == null)
    {
      localObject1 = paramIntent.getExtras();
      if (localObject1 == null) {
        break label258;
      }
      localObject1 = ((Bundle)localObject1).getParcelableArrayList("fileinfo_array");
      if (localObject1 == null) {
        break label258;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = (ArrayList)localObject1;
        if (localObject1 == null)
        {
          b(this.jdField_a_of_type_AndroidContentContext.getString(2131693811));
          return false;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localIterator = null;
        continue;
        localObject2 = new ArrayList();
        localIterator = localIterator.iterator();
        if (localIterator.hasNext())
        {
          ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
          if (!FileUtils.b(localForwardFileInfo.a())) {
            continue;
          }
          ((List)localObject2).add(localForwardFileInfo.a());
          continue;
        }
        if ((localArrayList == null) || (localArrayList.isEmpty()))
        {
          b(this.jdField_a_of_type_AndroidContentContext.getString(2131693811));
          return false;
        }
        a((List)localObject2, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
      }
      for (;;)
      {
        return true;
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          if ((localObject2 == null) || (((String)localObject2).equals("/"))) {
            localIterator.remove();
          }
        }
        if (localArrayList.isEmpty())
        {
          b(this.jdField_a_of_type_AndroidContentContext.getString(2131693811));
          return false;
        }
        a(localArrayList, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
      }
      label258:
      Iterator localIterator = null;
    }
  }
  
  private boolean d(Intent paramIntent)
  {
    return (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo") != null;
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      paramIntent = new Bundle();
      paramIntent.putString("uin", AppConstants.DATALINE_PC_UIN);
      paramIntent.putInt("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), paramIntent);
      return;
    }
    b(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineOldForwardHandler
 * JD-Core Version:    0.7.0.1
 */