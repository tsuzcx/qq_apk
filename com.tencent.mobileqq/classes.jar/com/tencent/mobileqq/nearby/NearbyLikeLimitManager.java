package com.tencent.mobileqq.nearby;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
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
  implements INearbyLikeLimitManager, Manager
{
  protected QQAppInterface a;
  protected INearbyLikeLimitManager.LimitInfo b = new INearbyLikeLimitManager.LimitInfo();
  protected HashMap<Long, INearbyLikeLimitManager.LikeItem> c = new HashMap();
  protected HashSet<String> d = new HashSet();
  protected boolean e = true;
  protected boolean f = true;
  
  public NearbyLikeLimitManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    String str = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("over_people_limit_tip_show_date");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.e = (localSharedPreferences.getString(localStringBuilder.toString(), "").equals(str) ^ true);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("over_one_limit_tip_show_date");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.f = (localSharedPreferences.getString(localStringBuilder.toString(), "").equals(str) ^ true);
  }
  
  private SpannableString a(List<oidb_0x8e7.Text> paramList)
  {
    Object localObject1 = null;
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return null;
      }
      localObject1 = new StringBuilder();
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(((oidb_0x8e7.Text)((Iterator)localObject2).next()).bytes_context.get().toStringUtf8());
      }
      if (((StringBuilder)localObject1).length() == 0) {
        return null;
      }
      localObject2 = new SpannableString(((StringBuilder)localObject1).toString());
      paramList = paramList.iterator();
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (!paramList.hasNext()) {
          break;
        }
        localObject1 = (oidb_0x8e7.Text)paramList.next();
        int j = ((oidb_0x8e7.Text)localObject1).bytes_context.get().toStringUtf8().length();
        if (((oidb_0x8e7.Text)localObject1).uint32_color.has()) {
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor(String.format("#%x", new Object[] { Integer.valueOf(((oidb_0x8e7.Text)localObject1).uint32_color.get()) }))), i, i + j, 33);
        }
        i += j;
      }
    }
    return localObject1;
  }
  
  public SpannableString a()
  {
    INearbyLikeLimitManager.LimitInfo localLimitInfo = this.b;
    if ((localLimitInfo != null) && (localLimitInfo.e != null)) {
      return a(((oidb_0x8e7.WarnMsg)this.b.e).rpt_msg_first_info.get());
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.b != null)
      {
        this.b.a = paramInt1;
        this.b.f = paramInt2;
        this.b.g = paramInt3;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateFromServer, level=");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", freeLikePeopleLimit=");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(", freeLikeOneLimit=");
          localStringBuilder.append(paramInt3);
          QLog.d("NearbyLikeLimitManager", 2, localStringBuilder.toString());
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
        if (this.b == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "updateItem, mLimitInfo == null, return");
          }
          return;
        }
        Object localObject1 = (INearbyLikeLimitManager.LikeItem)this.c.get(Long.valueOf(paramLong));
        Object localObject3;
        if (localObject1 == null)
        {
          if ((paramInt1 > 0) || (paramInt2 > 0))
          {
            localObject1 = new INearbyLikeLimitManager.LikeItem();
            ((INearbyLikeLimitManager.LikeItem)localObject1).a = paramLong;
            ((INearbyLikeLimitManager.LikeItem)localObject1).b += paramInt1;
            ((INearbyLikeLimitManager.LikeItem)localObject1).c += paramInt2;
            ((INearbyLikeLimitManager.LikeItem)localObject1).d += this.b.b * paramInt2;
            this.c.put(Long.valueOf(paramLong), localObject1);
            localObject3 = this.b;
            ((INearbyLikeLimitManager.LimitInfo)localObject3).i += 1;
            localObject3 = this.b;
            ((INearbyLikeLimitManager.LimitInfo)localObject3).h -= this.b.b * paramInt2;
          }
        }
        else
        {
          ((INearbyLikeLimitManager.LikeItem)localObject1).b += paramInt1;
          ((INearbyLikeLimitManager.LikeItem)localObject1).c += paramInt2;
          ((INearbyLikeLimitManager.LikeItem)localObject1).d += this.b.b * paramInt2;
          this.c.put(Long.valueOf(paramLong), localObject1);
          localObject3 = this.b;
          ((INearbyLikeLimitManager.LimitInfo)localObject3).h -= this.b.b * paramInt2;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateItem, key=");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append(", freeLikeCount=");
          ((StringBuilder)localObject3).append(paramInt1);
          ((StringBuilder)localObject3).append(", payLikeCount=");
          ((StringBuilder)localObject3).append(paramInt2);
          ((StringBuilder)localObject3).append(", hasLikeBefore=");
          if (localObject1 != null)
          {
            bool = true;
            ((StringBuilder)localObject3).append(bool);
            QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("");
          a(((StringBuilder)localObject1).toString(), true);
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void a(Activity paramActivity, Object paramObject1, String paramString1, Object paramObject2, String paramString2)
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)paramObject1;
        paramObject2 = (INearbyLikeLimitManager.onDoVoteListener)paramObject2;
        if (QLog.isColorLevel())
        {
          paramObject1 = new StringBuilder();
          paramObject1.append("checkCanDoVote, uin=");
          paramObject1.append(paramString1);
          paramObject1.append(", from=");
          paramObject1.append(paramString2);
          paramObject1.append(", mLimitInfo=");
          paramObject1.append(this.b);
          QLog.d("NearbyLikeLimitManager", 2, paramObject1.toString());
        }
        boolean bool1 = b(Long.valueOf(paramString1).longValue());
        boolean bool2 = c(Long.valueOf(paramString1).longValue());
        if ((!bool1) && (!bool2))
        {
          a(Long.valueOf(paramString1).longValue(), 1, 0);
          paramObject2.a(paramString1, true);
        }
        else
        {
          if ((bool1) && (g()))
          {
            paramObject1 = e();
            ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(localQQAppInterface, "exp_uv_limit", paramString2);
            break label406;
          }
          if ((!bool2) || (!h())) {
            break label412;
          }
          paramObject1 = f();
          ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(localQQAppInterface, "exp_pv_limit", paramString2);
          break label406;
          if (i != 0)
          {
            paramActivity = DialogUtil.a(paramActivity, 0, null, paramObject1, HardCodeUtil.a(2131905068), HardCodeUtil.a(2131905065), HardCodeUtil.a(2131898212), new NearbyLikeLimitManager.1(this, bool1, paramString1, paramObject2, localQQAppInterface, paramString2, paramActivity), new NearbyLikeLimitManager.2(this, paramActivity, localQQAppInterface, paramString2));
            paramActivity.getBtnLeft().setTextColor(-14698765);
            paramActivity.show();
          }
          else if (d())
          {
            a(Long.valueOf(paramString1).longValue(), 0, 1);
            paramObject2.a(paramString1, false);
            ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(localQQAppInterface, "pay_like", paramString1, paramString2, "", "", "");
          }
          else
          {
            a(paramActivity, paramString2);
            ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(localQQAppInterface, "exp_pay_like", paramString2);
          }
        }
        return;
      }
      finally {}
      label406:
      int i = 1;
      continue;
      label412:
      paramObject1 = null;
      i = 0;
    }
  }
  
  protected void a(Activity paramActivity, String paramString)
  {
    DialogUtil.a(paramActivity, 230).setTitle(HardCodeUtil.a(2131905069)).setMessage(HardCodeUtil.a(2131905066)).setNegativeButton(HardCodeUtil.a(2131898212), new NearbyLikeLimitManager.4(this)).setPositiveButton(HardCodeUtil.a(2131905067), new NearbyLikeLimitManager.3(this, paramActivity)).show();
  }
  
  public void a(Object paramObject, List<Object> paramList, int paramInt)
  {
    try
    {
      this.b = ((INearbyLikeLimitManager.LimitInfo)paramObject);
      if (paramInt == 511) {
        this.c.clear();
      }
      paramObject = new StringBuilder();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          INearbyLikeLimitManager.LikeItem localLikeItem = (INearbyLikeLimitManager.LikeItem)paramList.next();
          this.c.put(Long.valueOf(localLikeItem.a), localLikeItem);
          if (QLog.isColorLevel())
          {
            paramObject.append(localLikeItem);
            paramObject.append(" | ");
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateFromServer, mLimitInfo=");
        paramList.append(this.b);
        paramList.append(", mLikeItemMap=[");
        paramList.append(paramObject);
        paramList.append("]");
        QLog.d("NearbyLikeLimitManager", 2, paramList.toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (!paramBoolean) {
        this.d.remove(paramString);
      } else {
        this.d.add(paramString);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setNeedUpdateProfileCardFlag, key=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", isNeedUpdate=");
        localStringBuilder.append(paramBoolean);
        QLog.d("NearbyLikeLimitManager", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      INearbyLikeLimitManager.LikeItem localLikeItem = (INearbyLikeLimitManager.LikeItem)this.c.get(Long.valueOf(paramLong));
      INearbyLikeLimitManager.LimitInfo localLimitInfo = this.b;
      boolean bool = false;
      if ((localLimitInfo != null) && (localLikeItem != null))
      {
        int i = localLikeItem.c;
        if (i > 0) {
          bool = true;
        }
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool;
      if (TextUtils.isEmpty(paramString)) {
        bool = false;
      } else {
        bool = this.d.contains(paramString);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedUpdateProfileCard, ret=");
        localStringBuilder.append(bool);
        localStringBuilder.append(", key=");
        localStringBuilder.append(paramString);
        QLog.d("NearbyLikeLimitManager", 2, localStringBuilder.toString());
      }
      return bool;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("need_show_first_tip_");
      ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).getBoolean((String)localObject, true);
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedShowFirstTip");
        localStringBuilder.append(localException.toString());
        QLog.e("NearbyLikeLimitManager", 2, localStringBuilder.toString());
      }
    }
    return true;
  }
  
  public boolean b(long paramLong)
  {
    try
    {
      localObject1 = this.b;
      boolean bool2 = false;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isOverFreeLikePeopleLimit, mLimitInfo==null, return false, uin=");
          ((StringBuilder)localObject1).append(paramLong);
          QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
        }
        return false;
      }
      localObject1 = (INearbyLikeLimitManager.LikeItem)this.c.get(Long.valueOf(paramLong));
      if (localObject1 == null)
      {
        bool1 = bool2;
        if (this.b.i >= this.b.f) {
          break label226;
        }
      }
      else
      {
        bool1 = bool2;
        if (this.b.i >= this.b.f)
        {
          bool1 = bool2;
          if (((INearbyLikeLimitManager.LikeItem)localObject1).c > 0)
          {
            bool1 = bool2;
            if (((INearbyLikeLimitManager.LikeItem)localObject1).b != 0) {}
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        for (;;)
        {
          throw localObject2;
        }
        label226:
        boolean bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isOverFreeLikePeopleLimit, ret=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", uin=");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
    }
    return bool1;
  }
  
  public void c()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("need_show_first_tip_");
      ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putBoolean((String)localObject, false).commit();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disableShowFirstTip");
        localStringBuilder.append(localException.toString());
        QLog.e("NearbyLikeLimitManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean c(long paramLong)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (INearbyLikeLimitManager.LikeItem)this.c.get(Long.valueOf(paramLong));
        Object localObject3 = this.b;
        boolean bool2 = true;
        bool1 = true;
        if ((localObject3 != null) && (localObject1 != null))
        {
          if (((INearbyLikeLimitManager.LikeItem)localObject1).b >= this.b.g)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("isOVerFreeLikeOneLimit, uin=");
              ((StringBuilder)localObject1).append(paramLong);
              ((StringBuilder)localObject1).append(", ret=");
              ((StringBuilder)localObject1).append(bool1);
              QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
            }
            return bool1;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("isOVerFreeLikeOneLimit, mLimitInfo isNull=");
            if (this.b != null) {
              break label244;
            }
            bool1 = true;
            ((StringBuilder)localObject3).append(bool1);
            ((StringBuilder)localObject3).append(", item isNull=");
            if (localObject1 != null) {
              break label249;
            }
            bool1 = bool2;
            ((StringBuilder)localObject3).append(bool1);
            ((StringBuilder)localObject3).append(", uin=");
            ((StringBuilder)localObject3).append(paramLong);
            ((StringBuilder)localObject3).append(", return false");
            QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject3).toString());
          }
          return false;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label244:
      bool1 = false;
      continue;
      label249:
      bool1 = false;
    }
  }
  
  public boolean d()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.b;
        bool = true;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, mLimitInfo == null, return true");
          }
          return true;
        }
        if (this.b.h >= this.b.b)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isStockEnough, ret=");
            ((StringBuilder)localObject1).append(bool);
            QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public SpannableString e()
  {
    INearbyLikeLimitManager.LimitInfo localLimitInfo = this.b;
    if ((localLimitInfo != null) && (localLimitInfo.e != null)) {
      return a(((oidb_0x8e7.WarnMsg)this.b.e).rpt_msg_user_num_limit_info.get());
    }
    return null;
  }
  
  public SpannableString f()
  {
    INearbyLikeLimitManager.LimitInfo localLimitInfo = this.b;
    if ((localLimitInfo != null) && (localLimitInfo.e != null)) {
      return a(((oidb_0x8e7.WarnMsg)this.b.e).rpt_msg_zan_limit_info.get());
    }
    return null;
  }
  
  public boolean g()
  {
    Object localObject;
    if (this.e)
    {
      localObject = this.b;
      if ((localObject != null) && (((INearbyLikeLimitManager.LimitInfo)localObject).e != null))
      {
        bool = true;
        break label30;
      }
    }
    boolean bool = false;
    label30:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowOverPeopleLimitTip, ret=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean h()
  {
    Object localObject;
    if (this.f)
    {
      localObject = this.b;
      if ((localObject != null) && (((INearbyLikeLimitManager.LimitInfo)localObject).e != null))
      {
        bool = true;
        break label30;
      }
    }
    boolean bool = false;
    label30:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowOverOneLimitTip, ret=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void i()
  {
    Object localObject1 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("over_people_limit_tip_show_date");
    ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString((String)localObject2, (String)localObject1).commit();
    this.e = false;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("disableShowOverPeopleLimitTip, key=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void j()
  {
    Object localObject1 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("over_one_limit_tip_show_date");
    ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString((String)localObject2, (String)localObject1).commit();
    this.f = false;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("disableShowOverOneLimitTip, key=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.b = null;
      this.c.clear();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "onDestroy");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyLikeLimitManager
 * JD-Core Version:    0.7.0.1
 */