package com.tencent.mobileqq.nearby;

import adzb;
import adzc;
import adzd;
import adze;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.Text;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;

public class NearbyLikeLimitManager
  implements Manager
{
  protected QQAppInterface a;
  public NearbyLikeLimitManager.LimitInfo a;
  protected HashMap a;
  protected HashSet a;
  protected boolean a;
  protected boolean b = true;
  
  public NearbyLikeLimitManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo = new NearbyLikeLimitManager.LimitInfo();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    String str = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0);
    if (!localSharedPreferences.getString("over_people_limit_tip_show_date" + paramQQAppInterface.getCurrentAccountUin(), "").equals(str))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (localSharedPreferences.getString("over_one_limit_tip_show_date" + paramQQAppInterface.getCurrentAccountUin(), "").equals(str)) {
        break label178;
      }
    }
    label178:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private SpannableString a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((oidb_0x8e7.Text)((Iterator)localObject2).next()).bytes_context.get().toStringUtf8());
    }
    if (((StringBuilder)localObject1).length() == 0) {
      return null;
    }
    localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject2 = (oidb_0x8e7.Text)paramList.next();
      int j = ((oidb_0x8e7.Text)localObject2).bytes_context.get().toStringUtf8().length();
      if (((oidb_0x8e7.Text)localObject2).uint32_color.has()) {
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor(String.format("#%x", new Object[] { Integer.valueOf(((oidb_0x8e7.Text)localObject2).uint32_color.get()) }))), i, i + j, 33);
      }
      i += j;
    }
    return localObject1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, "", paramString2, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", paramString2, "pay_like", paramString1, 0, 0, paramString3, paramString4, paramString5, paramString6);
    if (QLog.isColorLevel()) {
      QLog.d("nearbyLike.report", 2, "report, opName=" + paramString1 + ", toUin=" + paramString2 + ", extra1=" + paramString3 + ", extra2=" + paramString4 + ", extra3=" + paramString5 + ", extra4=" + paramString6);
    }
  }
  
  public static boolean d(long paramLong)
  {
    if ((paramLong == 6L) || (paramLong == 8L) || (paramLong == 37L) || (paramLong == 41L) || (paramLong == 42L) || (paramLong == 43L) || (paramLong == 45L) || (paramLong == 46L) || (paramLong == 47L) || (paramLong == 51L) || (paramLong == 10002L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "isNeedNewLimitCheck, source=" + paramLong + ", ret=" + bool);
      }
      return bool;
    }
  }
  
  public SpannableString a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg == null)) {
      return null;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg.rpt_msg_first_info.get());
  }
  
  public void a()
  {
    try
    {
      String str = "need_show_first_tip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putBoolean(str, false).commit();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyLikeLimitManager", 2, "disableShowFirstTip" + localException.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.c = paramInt2;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.d = paramInt3;
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "updateFromServer, level=" + paramInt1 + ", freeLikePeopleLimit=" + paramInt2 + ", freeLikeOneLimit=" + paramInt3);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "updateItem, mLimitInfo == null, return");
          }
          return;
        }
        NearbyLikeLimitManager.LikeItem localLikeItem = (NearbyLikeLimitManager.LikeItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        if (localLikeItem == null)
        {
          if ((paramInt1 > 0) || (paramInt2 > 0))
          {
            localLikeItem = new NearbyLikeLimitManager.LikeItem();
            localLikeItem.jdField_a_of_type_Long = paramLong;
            localLikeItem.jdField_a_of_type_Int += paramInt1;
            localLikeItem.b += paramInt2;
            localLikeItem.c += this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.b * paramInt2;
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localLikeItem);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo;
            ((NearbyLikeLimitManager.LimitInfo)localObject2).f += 1;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo;
            ((NearbyLikeLimitManager.LimitInfo)localObject2).e -= this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.b * paramInt2;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("updateItem, key=").append(paramLong).append(", freeLikeCount=").append(paramInt1).append(", payLikeCount=").append(paramInt2).append(", hasLikeBefore=");
            if (localLikeItem == null) {
              break label377;
            }
            bool = true;
            QLog.d("NearbyLikeLimitManager", 2, bool);
          }
          a(paramLong + "", true);
          continue;
        }
        localObject1.jdField_a_of_type_Int += paramInt1;
      }
      finally {}
      localObject1.b += paramInt2;
      localObject1.c += this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.b * paramInt2;
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localObject1);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo;
      ((NearbyLikeLimitManager.LimitInfo)localObject2).e -= this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.b * paramInt2;
      continue;
      label377:
      boolean bool = false;
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, NearbyLikeLimitManager.onDoVoteListener paramonDoVoteListener, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "checkCanDoVote, uin=" + paramString1 + ", from=" + paramString2 + ", mLimitInfo=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo);
        }
        boolean bool1 = a(Long.valueOf(paramString1).longValue());
        boolean bool2 = b(Long.valueOf(paramString1).longValue());
        if ((!bool1) && (!bool2)) {
          break label297;
        }
        if ((bool1) && (c()))
        {
          localSpannableString = b();
          a(paramQQAppInterface, "exp_uv_limit", paramString2);
          i = 1;
          if (i != 0)
          {
            paramActivity = DialogUtil.a(paramActivity, 0, null, localSpannableString, "继续，且今日不再提醒", "提升等级，获得更多赞", "取消", new adzb(this, bool1, paramString1, paramonDoVoteListener, paramQQAppInterface, paramString2, paramActivity), new adzc(this, paramActivity, paramQQAppInterface, paramString2));
            paramActivity.getBtnLeft().setTextColor(-14698765);
            paramActivity.show();
          }
        }
        else
        {
          if ((!bool2) || (!d())) {
            break label322;
          }
          localSpannableString = c();
          a(paramQQAppInterface, "exp_pv_limit", paramString2);
          i = 1;
          continue;
        }
        if (a())
        {
          a(Long.valueOf(paramString1).longValue(), 0, 1);
          paramonDoVoteListener.a(paramString1, false);
          a(paramQQAppInterface, "pay_like", paramString1, paramString2, "", "", "");
          continue;
        }
        a(paramActivity, paramString2);
      }
      finally {}
      a(paramQQAppInterface, "exp_pay_like", paramString2);
      continue;
      label297:
      a(Long.valueOf(paramString1).longValue(), 1, 0);
      paramonDoVoteListener.a(paramString1, true);
      continue;
      label322:
      SpannableString localSpannableString = null;
      int i = 0;
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    DialogUtil.a(paramActivity, 230).setTitle("金豆数量不足").setMessage("你拥有的金豆数量不足，是否购买更多").setNegativeButton("取消", new adze(this)).setPositiveButton("购买", new adzd(this, paramActivity)).show();
  }
  
  public void a(NearbyLikeLimitManager.LimitInfo paramLimitInfo, List paramList, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo = paramLimitInfo;
      if (paramInt == 511) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      paramLimitInfo = new StringBuilder();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          NearbyLikeLimitManager.LikeItem localLikeItem = (NearbyLikeLimitManager.LikeItem)paramList.next();
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localLikeItem.jdField_a_of_type_Long), localLikeItem);
          if (QLog.isColorLevel()) {
            paramLimitInfo.append(localLikeItem).append(" | ");
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label165;
      }
    }
    finally {}
    QLog.d("NearbyLikeLimitManager", 2, "updateFromServer, mLimitInfo=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo + ", mLikeItemMap=[" + paramLimitInfo + "]");
    label165:
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (!paramBoolean)
        {
          this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "setNeedUpdateProfileCardFlag, uin=" + paramString + ", isNeedUpdate=" + paramBoolean);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
        }
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, mLimitInfo == null, return true");
            bool2 = bool1;
          }
          return bool2;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.e >= this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.b)
        {
          bool1 = bool2;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, ret=" + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    label165:
    label171:
    label219:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isOverFreeLikePeopleLimit, mLimitInfo==null, return false, uin=" + paramLong);
            bool2 = bool1;
          }
          return bool2;
        }
        NearbyLikeLimitManager.LikeItem localLikeItem = (NearbyLikeLimitManager.LikeItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        if (localLikeItem != null) {
          break label171;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.f < this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.c) {
          break label165;
        }
        bool1 = true;
      }
      finally {}
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyLikeLimitManager", 2, "isOverFreeLikePeopleLimit, ret=" + bool1 + ", uin=" + paramLong);
        bool2 = bool1;
        continue;
        bool1 = false;
        break label219;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.f >= this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.c) && (localObject.b > 0))
        {
          int i = localObject.jdField_a_of_type_Int;
          if (i != 0) {}
        }
        for (bool1 = bool2;; bool1 = false) {
          break;
        }
      }
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 494	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +51 -> 57
    //   9: iconst_0
    //   10: istore_2
    //   11: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +39 -> 53
    //   17: ldc 250
    //   19: iconst_2
    //   20: new 73	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 517
    //   30: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 260	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 514
    //   40: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 33	com/tencent/mobileqq/nearby/NearbyLikeLimitManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   61: aload_1
    //   62: invokevirtual 520	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   65: istore_2
    //   66: goto -55 -> 11
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	NearbyLikeLimitManager
    //   0	74	1	paramString	String
    //   10	56	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	69	finally
    //   11	53	69	finally
    //   57	66	69	finally
  }
  
  public SpannableString b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg == null)) {
      return null;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg.rpt_msg_user_num_limit_info.get());
  }
  
  public void b()
  {
    String str1 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    String str2 = "over_people_limit_tip_show_date" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString(str2, str1).commit();
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "disableShowOverPeopleLimitTip, key=" + str2);
    }
  }
  
  public boolean b()
  {
    boolean bool1 = true;
    try
    {
      String str = "need_show_first_tip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      boolean bool2 = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).getBoolean(str, true);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyLikeLimitManager", 2, "isNeedShowFirstTip" + localException.toString());
    }
    return bool1;
    return true;
  }
  
  public boolean b(long paramLong)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        NearbyLikeLimitManager.LikeItem localLikeItem = (NearbyLikeLimitManager.LikeItem)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        boolean bool1;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null) || (localLikeItem == null))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("isOVerFreeLikeOneLimit, mLimitInfo isNull=");
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null)
            {
              bool1 = true;
              localStringBuilder = localStringBuilder.append(bool1).append(", item isNull=");
              if (localLikeItem != null) {
                continue;
              }
              bool1 = bool2;
              QLog.d("NearbyLikeLimitManager", 2, bool1 + ", uin=" + paramLong + ", return false");
            }
          }
          else
          {
            bool2 = false;
            return bool2;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
        }
        if (localLikeItem.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.d)
        {
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isOVerFreeLikeOneLimit, uin=" + paramLong + ", ret=" + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public SpannableString c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg == null)) {
      return null;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg.rpt_msg_zan_limit_info.get());
  }
  
  public void c()
  {
    String str1 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    String str2 = "over_one_limit_tip_show_date" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString(str2, str1).commit();
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "disableShowOverOneLimitTip, key=" + str2);
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "isNeedShowOverPeopleLimitTip, ret=" + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  public boolean c(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/tencent/mobileqq/nearby/NearbyLikeLimitManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: lload_1
    //   7: invokestatic 326	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 329	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 331	com/tencent/mobileqq/nearby/NearbyLikeLimitManager$LikeItem
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 23	com/tencent/mobileqq/nearby/NearbyLikeLimitManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo	Lcom/tencent/mobileqq/nearby/NearbyLikeLimitManager$LimitInfo;
    //   22: astore 6
    //   24: aload 6
    //   26: ifnull +8 -> 34
    //   29: aload 5
    //   31: ifnonnull +11 -> 42
    //   34: iconst_0
    //   35: istore 4
    //   37: aload_0
    //   38: monitorexit
    //   39: iload 4
    //   41: ireturn
    //   42: aload 5
    //   44: getfield 338	com/tencent/mobileqq/nearby/NearbyLikeLimitManager$LikeItem:b	I
    //   47: istore_3
    //   48: iload_3
    //   49: ifle +9 -> 58
    //   52: iconst_1
    //   53: istore 4
    //   55: goto -18 -> 37
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -24 -> 37
    //   64: astore 5
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 5
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	NearbyLikeLimitManager
    //   0	71	1	paramLong	long
    //   47	2	3	i	int
    //   35	25	4	bool	boolean
    //   16	27	5	localLikeItem	NearbyLikeLimitManager.LikeItem
    //   64	5	5	localObject	Object
    //   22	3	6	localLimitInfo	NearbyLikeLimitManager.LimitInfo
    // Exception table:
    //   from	to	target	type
    //   2	24	64	finally
    //   42	48	64	finally
  }
  
  public boolean d()
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "isNeedShowOverOneLimitTip, ret=" + bool);
      }
      return bool;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$LimitInfo = null;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "onDestroy");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyLikeLimitManager
 * JD-Core Version:    0.7.0.1
 */