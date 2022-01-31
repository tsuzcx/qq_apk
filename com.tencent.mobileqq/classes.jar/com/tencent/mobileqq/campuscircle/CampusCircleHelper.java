package com.tencent.mobileqq.campuscircle;

import SummaryCard.RespSummaryCard;
import SummaryCard.TCampusCircleInfo;
import SummaryCard.TCampusSchoolInfo;
import abpg;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class CampusCircleHelper
{
  public static int a(long paramLong)
  {
    int j = 0;
    try
    {
      String str = String.valueOf(paramLong);
      i = j;
      if (str.length() > 2) {
        i = Integer.parseInt(str.substring(0, 2));
      }
    }
    catch (Exception localException)
    {
      do
      {
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("CampusCircleHelper", 2, String.format(Locale.getDefault(), "getSchoolTypeFromID lCampusSchoolID: %d", new Object[] { Long.valueOf(paramLong) }), localException);
    }
    return i;
    return 0;
  }
  
  public static int a(long paramLong, String paramString)
  {
    String[] arrayOfString;
    int i;
    switch (b(paramLong))
    {
    default: 
      arrayOfString = null;
      if ((paramString != null) && (arrayOfString != null))
      {
        i = 0;
        label46:
        if (i < arrayOfString.length) {
          if (!paramString.equals(arrayOfString[i])) {
            break;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramString = Calendar.getInstance();
      int j = paramString.get(1);
      int k = paramString.get(2);
      if (i >= 0)
      {
        if (k < 8)
        {
          return j - i - 1;
          arrayOfString = CampusCircleConstant.c;
          break;
          arrayOfString = CampusCircleConstant.b;
          break;
          arrayOfString = CampusCircleConstant.a;
          break;
          i += 1;
          break label46;
        }
        return j - i;
      }
      return j;
      i = -1;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (!a(paramQQAppInterface)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleHelper", 2, "getRedTouchCount, isLebaCampusCircleShow return false, not show redtouch");
      }
      return -1;
    }
    paramQQAppInterface = (LocalRedTouchManager)paramQQAppInterface.getManager(159);
    RedTouchItem localRedTouchItem1 = paramQQAppInterface.a(10017);
    RedTouchItem localRedTouchItem2 = paramQQAppInterface.a(103421);
    int i;
    if ((paramQQAppInterface.a(localRedTouchItem1, false)) && (localRedTouchItem1.passThroughLevel >= 1)) {
      if (localRedTouchItem1.redtouchType == 2)
      {
        i = localRedTouchItem1.count + 0;
        paramInt = 0;
      }
    }
    for (;;)
    {
      int k = paramInt;
      int j = i;
      if (paramQQAppInterface.a(localRedTouchItem2, false))
      {
        k = paramInt;
        j = i;
        if (localRedTouchItem2.passThroughLevel >= 2)
        {
          if (localRedTouchItem2.redtouchType != 2) {
            break label197;
          }
          j = i + localRedTouchItem2.count;
          k = paramInt;
        }
      }
      label145:
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleHelper", 2, String.format("getRedTouchCount redNumCount:%d redPointCount:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
      }
      if (j > 0) {}
      for (;;)
      {
        return j;
        paramInt = 1;
        i = 0;
        break;
        label197:
        k = paramInt + 1;
        j = i;
        break label145;
        if (k > 0) {
          j = 0;
        } else {
          j = -1;
        }
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  public static String a(long paramLong, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    if (localCalendar.get(2) < 8) {
      i = i - paramInt - 1;
    }
    for (;;)
    {
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      switch (b(paramLong))
      {
      default: 
        return "";
        i -= paramInt;
      }
    }
    i = paramInt;
    if (paramInt >= CampusCircleConstant.c.length) {
      i = CampusCircleConstant.c.length - 1;
    }
    return CampusCircleConstant.c[i];
    i = paramInt;
    if (paramInt >= CampusCircleConstant.b.length) {
      i = CampusCircleConstant.b.length - 1;
    }
    return CampusCircleConstant.b[i];
    i = paramInt;
    if (paramInt >= CampusCircleConstant.a.length) {
      i = CampusCircleConstant.a.length - 1;
    }
    return CampusCircleConstant.a[i];
  }
  
  public static String a(long paramLong, String paramString)
  {
    return String.format(Locale.getDefault(), "campus_college_%d_%s", new Object[] { Long.valueOf(paramLong), paramString });
  }
  
  public static String a(Card paramCard)
  {
    Object localObject;
    if (paramCard == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = paramCard.strCampusName;
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return paramCard.strNick;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch)
  {
    Object localObject1;
    Object localObject2;
    int j;
    boolean bool2;
    int i;
    boolean bool1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (LocalRedTouchManager)paramQQAppInterface.getManager(159);
      paramQQAppInterface = ((LocalRedTouchManager)localObject1).a(10017);
      localObject2 = ((LocalRedTouchManager)localObject1).a(103421);
      if (!((LocalRedTouchManager)localObject1).a(paramQQAppInterface, false)) {
        break label1105;
      }
      if (paramQQAppInterface.redtouchType != 2) {
        break label204;
      }
      j = paramQQAppInterface.count;
      bool2 = false;
      i = 0;
      j += 0;
      bool1 = true;
    }
    for (;;)
    {
      int k = i;
      int m = j;
      if (((LocalRedTouchManager)localObject1).a((RedTouchItem)localObject2, false))
      {
        k = i;
        m = j;
        if (((RedTouchItem)localObject2).passThroughLevel >= 1)
        {
          if (((RedTouchItem)localObject2).redtouchType != 2) {
            break label268;
          }
          m = j + ((RedTouchItem)localObject2).count;
          k = i;
        }
      }
      label122:
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircleHelper", 2, "updateEntryRedTouch redNum:" + m + " redPoint:" + k + " hasUnnormal:" + bool2 + " isText:" + bool1);
      }
      if ((m <= 0) && (k <= 0) && (!bool2)) {
        paramRedTouch.b();
      }
      label204:
      do
      {
        for (;;)
        {
          return;
          if (paramQQAppInterface.redtouchType == 1)
          {
            bool1 = true;
            bool2 = false;
            i = 1;
            j = 0;
            break;
          }
          if ((paramQQAppInterface.redtouchType != 3) && (paramQQAppInterface.redtouchType != 4)) {
            break label1105;
          }
          if (paramQQAppInterface.redtouchType == 4) {}
          for (bool1 = true;; bool1 = false)
          {
            bool2 = true;
            i = 0;
            j = 0;
            break;
          }
          k = i + 1;
          m = j;
          break label122;
          if (m > 0)
          {
            paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject1 = new BusinessInfoCheckUpdate.AppInfo();
            if (m > 99) {
              paramQQAppInterface.red_content.set("99+");
            }
            for (;;)
            {
              paramQQAppInterface.red_type.set(5);
              paramQQAppInterface.red_desc.set("{'cn':'#FF0000'}");
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add(paramQQAppInterface);
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
              paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
              return;
              paramQQAppInterface.red_content.set(String.valueOf(m));
            }
          }
          if ((bool2) && (bool1))
          {
            localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject2 = new BusinessInfoCheckUpdate.AppInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(paramQQAppInterface.tips);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
            ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.add((MessageMicro)localObject1);
            ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(1);
            paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            return;
          }
          if ((!bool2) || (bool1)) {
            break label1034;
          }
          localObject1 = new BusinessInfoCheckUpdate.AppInfo();
          if (!TextUtils.isEmpty(paramQQAppInterface.icon))
          {
            if (!TextUtils.isEmpty(paramQQAppInterface.tips))
            {
              localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(paramQQAppInterface.tips);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(4);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#00000000','cr':'#888888'}");
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
              localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(DisplayUtil.a(BaseApplicationImpl.sApplication.getApplicationContext(), 3.0F) + "");
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(9);
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
            }
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(paramQQAppInterface.icon);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(3);
            paramQQAppInterface = new JSONObject();
            try
            {
              paramQQAppInterface.put("dot", 1);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set(paramQQAppInterface.toString());
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
              paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
              try
              {
                paramQQAppInterface = (TextView)paramRedTouch.findViewById(30);
                localObject1 = (LinearLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
                ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
                ((LinearLayout.LayoutParams)localObject1).width = 0;
                paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
                paramQQAppInterface.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                paramQQAppInterface = paramRedTouch.findViewById(100);
                paramQQAppInterface.setPadding(AIOUtils.a(160.0F, paramQQAppInterface.getResources()), paramQQAppInterface.getPaddingTop(), paramQQAppInterface.getPaddingRight(), paramQQAppInterface.getPaddingBottom());
                return;
              }
              catch (Exception paramQQAppInterface) {}
              if (QLog.isColorLevel())
              {
                QLog.i("CampusCircleHelper", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
                return;
              }
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(paramQQAppInterface.tips);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(4);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#00000000','cr':'#888888'}");
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add((MessageMicro)localObject2);
        paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramQQAppInterface.red_type.set(0);
        paramQQAppInterface.red_desc.set("");
        paramQQAppInterface.red_content.set("");
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add(paramQQAppInterface);
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
        paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
        try
        {
          paramQQAppInterface = (TextView)paramRedTouch.findViewById(30);
          localObject1 = (LinearLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          ((LinearLayout.LayoutParams)localObject1).width = 0;
          paramQQAppInterface.setEllipsize(TextUtils.TruncateAt.END);
          paramQQAppInterface.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramQQAppInterface = paramRedTouch.findViewById(100);
          paramQQAppInterface.setPadding(AIOUtils.a(160.0F, paramQQAppInterface.getResources()), paramQQAppInterface.getPaddingTop(), paramQQAppInterface.getPaddingRight(), paramQQAppInterface.getPaddingBottom());
          return;
        }
        catch (Exception paramQQAppInterface) {}
      } while (!QLog.isColorLevel());
      label268:
      QLog.i("CampusCircleHelper", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
      return;
      label1034:
      paramQQAppInterface = new BusinessInfoCheckUpdate.RedTypeInfo();
      localObject1 = new BusinessInfoCheckUpdate.AppInfo();
      paramQQAppInterface.red_type.set(0);
      paramQQAppInterface.red_desc.set("");
      paramQQAppInterface.red_content.set("");
      ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.add(paramQQAppInterface);
      ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(1);
      paramRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      return;
      label1105:
      bool1 = true;
      bool2 = false;
      i = 0;
      j = 0;
    }
  }
  
  public static void a(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    if ((paramCard == null) || (paramRespSummaryCard == null)) {
      return;
    }
    paramCard.nCampusStatus = paramRespSummaryCard.stCampusCircleInfo.eStatus;
    paramCard.iCampusIsSigned = paramRespSummaryCard.stCampusCircleInfo.iIsSigned;
    paramCard.strCampusName = paramRespSummaryCard.stCampusCircleInfo.strName;
    paramCard.strCampusAcademy = paramRespSummaryCard.stCampusCircleInfo.strAcademy;
    if (paramRespSummaryCard.stCampusCircleInfo.stSchoolInfo != null)
    {
      paramCard.lCampusLastModifySchoolTime = paramRespSummaryCard.stCampusCircleInfo.stSchoolInfo.uTimestamp;
      paramCard.lCampusSchoolID = paramRespSummaryCard.stCampusCircleInfo.stSchoolInfo.uSchoolId;
      paramCard.nCampusSchoolFlag = paramRespSummaryCard.stCampusCircleInfo.stSchoolInfo.iIsValidForCertified;
    }
    if ((!TextUtils.isEmpty(paramCard.strCampusAcademy)) && (paramCard.lCampusSchoolID != 0L)) {
      paramCard.strCampusSchool = paramCard.strSchool;
    }
    for (;;)
    {
      try
      {
        int i = b(paramCard.lCampusSchoolID);
        paramRespSummaryCard = paramCard.strCampusAcademy.split(" ");
        if ((i != 4) || (paramRespSummaryCard.length != 3)) {
          continue;
        }
        paramCard.strCampusCollege = paramRespSummaryCard[1];
        paramCard.nCampusEnrolYear = Integer.parseInt(paramRespSummaryCard[2].replace("级", ""));
      }
      catch (Exception paramRespSummaryCard)
      {
        paramRespSummaryCard.printStackTrace();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      paramRespSummaryCard = new StringBuilder(500);
      paramRespSummaryCard.append("updateCampusInfo [").append(", uin: ").append(Utils.b(paramCard.uin)).append(", name: ").append(Utils.b(paramCard.strCampusName)).append(", strCampusAcademy: ").append(paramCard.strCampusAcademy).append(", sig: ").append(Utils.a(paramCard.tempChatSig)).append(", nCampusStatus: ").append(paramCard.nCampusStatus).append(", lCampusSchoolID: ").append(paramCard.lCampusSchoolID).append(", nCampusSchoolFlag: ").append(paramCard.nCampusSchoolFlag).append(", lCampusLastModifySchoolTime: ").append(paramCard.lCampusLastModifySchoolTime).append(", strCampusSchool: ").append(paramCard.strCampusSchool).append(", strCampusClass: ").append(paramCard.strCampusClass).append(", strCampusCollege: ").append(paramCard.strCampusCollege).append(", strSchool: ").append(paramCard.strSchool).append("]");
      QLog.i("CampusCircleHelper", 4, paramRespSummaryCard.toString());
      return;
      if (paramRespSummaryCard.length == 3)
      {
        paramCard.nCampusEnrolYear = a(paramCard.lCampusSchoolID, paramRespSummaryCard[1]);
        paramCard.strCampusClass = paramRespSummaryCard[2];
        continue;
        paramCard.strCampusAcademy = "";
        paramCard.strCampusSchool = "";
        paramCard.strCampusClass = "";
        paramCard.strCampusCollege = "";
        paramCard.nCampusEnrolYear = 0;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    ThreadManager.post(new abpg(paramInt, paramString1, paramString2, Math.abs(SystemClock.elapsedRealtime() - paramLong)), 5, null, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    Object localObject = paramQQAppInterface.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleHelper", 2, "isLebaCampusCircleShow, list is null, return false");
      }
      return false;
    }
    int i = 0;
    if (i < ((List)localObject).size())
    {
      ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)((List)localObject).get(i);
      if ((localResourcePluginInfo == null) || (localResourcePluginInfo.uiResId != 4086L)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleHelper", 2, "isLebaCampusCircleShow, is=4086, find=" + bool1);
      }
      if (!bool1) {
        break;
      }
      localObject = paramQQAppInterface.a().a;
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleHelper", 2, "isLebaCampusCircleShow, campusLebaEntryChecker is null");
        }
      }
      while (((CampusLebaEntryChecker)localObject).a)
      {
        paramQQAppInterface = ((RedTouchManager)paramQQAppInterface.getManager(35)).b().iterator();
        do
        {
          bool1 = bool2;
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
          localObject = (BusinessInfoCheckUpdate.AppSetting)paramQQAppInterface.next();
        } while (((BusinessInfoCheckUpdate.AppSetting)localObject).appid.get() != 4086);
        bool2 = ((BusinessInfoCheckUpdate.AppSetting)localObject).setting.get();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CampusCircleHelper", 2, "isLebaCampusCircleShow find appid 4086");
          bool1 = bool2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleHelper", 2, "isLebaCampusCircleShow return " + bool1);
        }
        return bool1;
        i += 1;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CampusCircleHelper", 2, "isLebaCampusCircleShow, switch is off, return false");
      return false;
    }
  }
  
  public static int b(long paramLong)
  {
    int j = 0;
    int k = a(paramLong);
    int i;
    if ((k >= 40) && (k <= 49)) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        if ((k >= 30) && (k <= 39)) {
          return 3;
        }
        if ((k >= 20) && (k <= 29)) {
          return 2;
        }
        i = j;
      } while (k < 10);
      i = j;
    } while (k > 19);
    return 1;
  }
  
  public static String b(Card paramCard)
  {
    if (paramCard == null) {
      return "";
    }
    if ((!TextUtils.isEmpty(paramCard.strCampusSchool)) && (!TextUtils.isEmpty(paramCard.strCampusCollege))) {
      return String.format(Locale.getDefault(), "%s %s", new Object[] { paramCard.strCampusSchool, paramCard.strCampusCollege });
    }
    if (!TextUtils.isEmpty(paramCard.strCampusAcademy))
    {
      String[] arrayOfString = paramCard.strCampusAcademy.split(" ");
      if ((arrayOfString.length == 3) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
        return String.format(Locale.getDefault(), "%s %s", new Object[] { arrayOfString[0], arrayOfString[1] });
      }
      return paramCard.strCampusAcademy;
    }
    return paramCard.strSchool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleHelper
 * JD-Core Version:    0.7.0.1
 */