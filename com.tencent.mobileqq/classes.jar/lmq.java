import android.support.v4.app.FragmentManager;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class lmq
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList;
    Object localObject1;
    if (ReadinjoySPEventReport.b(24))
    {
      localArrayList = new ArrayList();
      localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 == null) || (!(localObject1 instanceof SplashActivity))) {}
    }
    for (;;)
    {
      try
      {
        Object localObject2 = (MainFragment)((SplashActivity)localObject1).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        int i = ((View)((MainFragment)localObject2).a().get("消息_num")).getVisibility();
        Object localObject3 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(1);
        ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("MsgRedStatus");
        PBStringField localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
        if (i != 0) {
          continue;
        }
        localObject1 = String.valueOf(1);
        localPBStringField.set((String)localObject1);
        localArrayList.add(localObject3);
        boolean bool = ((MainFragment)localObject2).a("联系人").a();
        localObject3 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(2);
        ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("ContactsRedStatus");
        localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
        if (!bool) {
          continue;
        }
        localObject1 = String.valueOf(1);
        localPBStringField.set((String)localObject1);
        localArrayList.add(localObject3);
        bool = ((MainFragment)localObject2).a("动态").a();
        localObject3 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("TrendsRedStatus");
        localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
        if (!bool) {
          continue;
        }
        localObject1 = String.valueOf(1);
        localPBStringField.set((String)localObject1);
        localArrayList.add(localObject3);
        if (ReadInJoyHelper.h())
        {
          bool = ((MainFragment)localObject2).a("看点").a();
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(4);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KandianRedStatus");
          localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
          if (!bool) {
            continue;
          }
          localObject1 = String.valueOf(1);
          ((PBStringField)localObject3).set((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      catch (Exception localException)
      {
        AIOUtils.a("reportTabExposure_ERROR", "reportTabExposure_ERROR", localException);
        continue;
      }
      PublicAccountUtil.a(24, "TabExposure", localArrayList);
      return;
      localObject1 = String.valueOf(0);
      continue;
      localObject1 = String.valueOf(0);
      continue;
      localObject1 = String.valueOf(0);
      continue;
      localObject1 = String.valueOf(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmq
 * JD-Core Version:    0.7.0.1
 */