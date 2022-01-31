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

public final class lpa
  implements Runnable
{
  public void run()
  {
    if (ReadinjoySPEventReport.b(24))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = BaseActivity.sTopActivity;
      if ((localObject != null) && ((localObject instanceof SplashActivity))) {}
      for (;;)
      {
        try
        {
          MainFragment localMainFragment = (MainFragment)((SplashActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
          localObject = (View)localMainFragment.a().get("消息_num");
          if (localObject == null) {
            return;
          }
          int i = ((View)localObject).getVisibility();
          oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(1);
          localAttributeList.att_name.set("MsgRedStatus");
          PBStringField localPBStringField = localAttributeList.att_value;
          if (i != 0) {
            continue;
          }
          localObject = String.valueOf(1);
          localPBStringField.set((String)localObject);
          localArrayList.add(localAttributeList);
          boolean bool = localMainFragment.a("联系人").a();
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(2);
          localAttributeList.att_name.set("ContactsRedStatus");
          localPBStringField = localAttributeList.att_value;
          if (!bool) {
            continue;
          }
          localObject = String.valueOf(1);
          localPBStringField.set((String)localObject);
          localArrayList.add(localAttributeList);
          bool = localMainFragment.a("动态").a();
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(3);
          localAttributeList.att_name.set("TrendsRedStatus");
          localPBStringField = localAttributeList.att_value;
          if (!bool) {
            continue;
          }
          localObject = String.valueOf(1);
          localPBStringField.set((String)localObject);
          localArrayList.add(localAttributeList);
          if (ReadInJoyHelper.h())
          {
            localObject = localMainFragment.a("看点");
            if (localObject != null)
            {
              bool = ((RedTouch)localObject).a();
              localAttributeList = new oidb_cmd0x80a.AttributeList();
              localAttributeList.att_id.set(4);
              localAttributeList.att_name.set("KandianRedStatus");
              localPBStringField = localAttributeList.att_value;
              if (!bool) {
                continue;
              }
              localObject = String.valueOf(1);
              localPBStringField.set((String)localObject);
              localArrayList.add(localAttributeList);
            }
          }
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("tab");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + ReadinjoySPEventReport.b(localMainFragment.a()));
          localArrayList.add(localObject);
        }
        catch (Exception localException)
        {
          AIOUtils.a("reportTabExposure_ERROR", "reportTabExposure_ERROR", localException);
          continue;
        }
        PublicAccountUtil.a(24, "TabExposure", localArrayList);
        return;
        localObject = String.valueOf(0);
        continue;
        localObject = String.valueOf(0);
        continue;
        localObject = String.valueOf(0);
        continue;
        localObject = String.valueOf(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpa
 * JD-Core Version:    0.7.0.1
 */