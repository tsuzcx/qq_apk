import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import org.json.JSONException;
import org.json.JSONObject;

public class pto
  implements bhqp
{
  public pto(NativeShareView paramNativeShareView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeShareView", 2, "OnItemClickListener : position = " + paramInt + ", view = " + paramView + ", id = " + paramLong);
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (NativeShareView.a(this.a) != null) {
      NativeShareView.a(this.a).run();
    }
    int i = ((aybv)paramAdapterView).a.action;
    paramInt = 0;
    switch (i)
    {
    }
    for (;;)
    {
      paramAdapterView = new JSONObject();
      try
      {
        paramAdapterView.put("channel_type", paramInt);
        nrt.a(null, "", "0X800A3BE", "0X800A3BE", 0, 0, "", "", "", paramAdapterView.toString(), false);
        return;
        paramInt = 6;
        tae.a(NativeShareView.a(this.a));
        continue;
        tae.a((Activity)NativeShareView.a(this.a));
        paramInt = 1;
        continue;
        tae.a((BaseActivity)NativeShareView.a(this.a));
        paramInt = 2;
        continue;
        tae.b((Activity)NativeShareView.a(this.a));
        paramInt = 3;
        continue;
        tae.c((Activity)NativeShareView.a(this.a));
        paramInt = 4;
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          QLog.e("NativeShareView", 1, paramView, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pto
 * JD-Core Version:    0.7.0.1
 */