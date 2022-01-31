package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.LebaUtils;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class NearByPluginAction
  extends PluginAction
{
  static long a;
  
  public NearByPluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    QQAppInterface localQQAppInterface = a();
    if ((localQQAppInterface == null) || (paramImageView == null)) {}
    do
    {
      return;
      if (LebaUtils.a(localQQAppInterface.getAccount()))
      {
        paramImageView.setImageResource(2130842670);
        return;
      }
    } while (paramBitmap == null);
    paramImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - jdField_a_of_type_Long);
    if ((l2 >= 0L) && (l2 < 2000L)) {
      return;
    }
    jdField_a_of_type_Long = l1;
  }
  
  public void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    b(paramImageView, paramBitmap);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo, View paramView)
  {
    paramLebaGridItemInfo = a();
    paramView = (RedTouch)paramView;
    Object localObject = (TroopRedTouchManager)paramLebaGridItemInfo.getManager(69);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = ((TroopRedTouchManager)localObject).a();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo3;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo4;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo5;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo6;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo7;
    int i;
    boolean bool;
    if (((TroopRedTouchManager)localObject).a()) {
      if (NearbyConfigUtil.a(paramLebaGridItemInfo))
      {
        localRedTypeInfo3 = ((TroopRedTouchManager)localObject).b();
        localRedTypeInfo4 = ((TroopRedTouchManager)localObject).d();
        localRedTypeInfo2 = ((TroopRedTouchManager)localObject).f();
        localRedTypeInfo5 = ((TroopRedTouchManager)localObject).h();
        localRedTypeInfo6 = ((TroopRedTouchManager)localObject).i();
        localRedTypeInfo7 = ((TroopRedTouchManager)localObject).g();
        localObject = ((TroopRedTouchManager)localObject).j();
        if ((localRedTypeInfo2 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 1))) {
          if (localRedTypeInfo2.red_type.get() == 0)
          {
            paramView.a(localRedTypeInfo2);
            i = 0;
            bool = true;
            label127:
            paramLebaGridItemInfo.reportClickEvent("dc00899", "grp_lbs", "", "nearby_entry", "exp_red", 0, 0, String.valueOf(i), "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("nearby.redpoint", 2, "leba->updateNearbyRedPoint, needShow, isNewTab=" + bool + ", redType=" + i);
            }
          }
        }
      }
    }
    do
    {
      return;
      if (localRedTypeInfo2.red_type.get() == 5)
      {
        localRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo1.red_type.set(5);
        localRedTypeInfo1.red_content.set(localRedTypeInfo2.red_content.get());
        localRedTypeInfo1.red_desc.set("{'cn':'#FF0000'}");
        paramView.a(localRedTypeInfo1);
        i = 0;
        break;
        if ((localRedTypeInfo1 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 2)))
        {
          paramView.a(localRedTypeInfo1);
          i = 2;
          break;
        }
        if ((localRedTypeInfo3 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 3)))
        {
          paramView.a(localRedTypeInfo3);
          i = 3;
          break;
        }
        if ((localRedTypeInfo4 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 5)))
        {
          paramView.a(localRedTypeInfo4);
          i = 4;
          break;
        }
        if ((localRedTypeInfo5 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 4)))
        {
          paramView.a(localRedTypeInfo5);
          i = 5;
          break;
        }
        if ((localRedTypeInfo6 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 6)))
        {
          paramView.a(localRedTypeInfo6);
          i = 6;
          break;
        }
        if ((localRedTypeInfo7 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 1)))
        {
          paramView.a(localRedTypeInfo7);
          i = 7;
          break;
        }
        if (localObject != null)
        {
          paramView.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
          i = 8;
          break;
        }
        paramView.a(null);
      }
      i = 0;
      break;
      localRedTypeInfo2 = ((TroopRedTouchManager)localObject).c();
      if (localRedTypeInfo2 != null)
      {
        paramView.a(localRedTypeInfo2);
        i = 11;
        bool = false;
        break label127;
      }
      if ((localRedTypeInfo1 != null) && (NearbyConfigUtil.a(paramLebaGridItemInfo, 1001)))
      {
        paramView.a(localRedTypeInfo1);
        i = 12;
        bool = false;
        break label127;
      }
      paramView.a(null);
      i = 0;
      bool = false;
      break label127;
      paramView.a(null);
      paramLebaGridItemInfo.reportClickEvent("dc00899", "grp_lbs", "", "nearby_entry", "clk_red", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("nearby.redpoint", 2, "leba->updateNearbyRedPoint, don't needShow");
  }
  
  public void b(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    if (paramLebaGridItemInfo == null) {
      return;
    }
    paramLebaGridItemInfo = paramLebaGridItemInfo.a;
    paramLebaGridItemInfo = (Bitmap)BaseApplicationImpl.sImageHashMap.get(paramLebaGridItemInfo);
    b((ImageView)paramView.findViewById(2131366363), paramLebaGridItemInfo);
  }
  
  public void b(LebaGridItemInfo paramLebaGridItemInfo)
  {
    paramLebaGridItemInfo = a();
    LebaShowListManager.a |= 0x1;
    ((TroopRedTouchManager)paramLebaGridItemInfo.getManager(69)).a(false);
  }
  
  public void c(LebaGridItemInfo paramLebaGridItemInfo)
  {
    Object localObject1 = a();
    paramLebaGridItemInfo = (RedTouchManager)((QQAppInterface)localObject1).getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramLebaGridItemInfo.a(String.valueOf(100510));
    paramLebaGridItemInfo = paramLebaGridItemInfo.a("100510.100517");
    label117:
    int j;
    if (paramLebaGridItemInfo.buffer.has())
    {
      paramLebaGridItemInfo = paramLebaGridItemInfo.buffer.get();
      if ((!localAppInfo.red_display_info.has()) || (!localAppInfo.red_display_info.red_type_info.has())) {
        break label160;
      }
      Object localObject2 = localAppInfo.red_display_info.red_type_info.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label160;
      }
      localObject2 = ((List)localObject2).iterator();
      int i = 2;
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break label162;
      }
      if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject2).next()).red_type.get() != 3) {
        break label421;
      }
      i = 1;
    }
    label160:
    label162:
    label421:
    for (;;)
    {
      break label117;
      paramLebaGridItemInfo = "";
      break;
      j = 2;
      if ((localAppInfo.iNewFlag.has()) && (localAppInfo.iNewFlag.get() == 1)) {
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        NearbyProcessMonitor.b(0);
        if (!NearbySPUtil.f(((QQAppInterface)localObject1).getAccount()))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject1).putExtra("FROM_WHERE", 0);
          ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", paramLebaGridItemInfo);
          ((Intent)localObject1).putExtra("NEARBY_IS_HAS_ICON", j);
          NearbyFakeActivity.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
        }
        for (;;)
        {
          ReadinjoySPEventReport.a().a("FuJin", bool);
          return;
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyGuideActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject1).putExtra("FROM_WHERE", 0);
          ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", paramLebaGridItemInfo);
          ((Intent)localObject1).putExtra("NEARBY_IS_HAS_ICON", j);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.NearByPluginAction
 * JD-Core Version:    0.7.0.1
 */