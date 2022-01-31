import android.support.v4.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class lmr
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList;
    oidb_cmd0x80a.AttributeList localAttributeList;
    if (ReadinjoySPEventReport.b(8))
    {
      localArrayList = new ArrayList();
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("DTHasRed");
      PBStringField localPBStringField = localAttributeList.att_value;
      if (!ReadinjoySPEventReport.b()) {
        break label191;
      }
      localObject = String.valueOf(1);
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localObject = BaseActivity.sTopActivity;
      if ((localObject != null) && ((localObject instanceof SplashActivity)))
      {
        localObject = (MainFragment)((SplashActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (localObject == null) {
          break label259;
        }
      }
    }
    label259:
    for (Object localObject = ((MainFragment)localObject).b();; localObject = null)
    {
      if (localObject != null)
      {
        if (!((String)localObject).equals(Conversation.class.getName())) {
          break label199;
        }
        localObject = "1";
      }
      for (;;)
      {
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(2);
        localAttributeList.att_name.set("tab");
        localAttributeList.att_value.set((String)localObject);
        localArrayList.add(localAttributeList);
        PublicAccountUtil.a(8, "InForeground", localArrayList);
        ReadinjoySPEventReport.a(System.currentTimeMillis());
        return;
        label191:
        localObject = String.valueOf(0);
        break;
        label199:
        if (((String)localObject).equals(Contacts.class.getName())) {
          localObject = "2";
        } else if (((String)localObject).equals(Leba.class.getName())) {
          localObject = "4";
        } else if (((String)localObject).equals(ReadinjoyTabFrame.class.getName())) {
          localObject = "3";
        } else {
          localObject = "0";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmr
 * JD-Core Version:    0.7.0.1
 */