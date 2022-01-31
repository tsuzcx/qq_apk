import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubscribeFragement;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class lqv
  implements View.OnClickListener
{
  lqv(lqu paramlqu) {}
  
  public void onClick(View paramView)
  {
    if (lqu.a(this.a) != null)
    {
      paramView = (Context)lqu.a(this.a).get();
      if (paramView != null)
      {
        this.a.b();
        ReadInJoyUtils.a(paramView, ReadInJoyHelper.g(ReadInJoySubscribeFragement.a(this.a.a)));
        paramView = (KandianMergeManager)ReadInJoySubscribeFragement.a(this.a.a).getManager(161);
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", ReadInJoyUtils.d);
        KandianOx210MsgInfo.Biu0x210Msg localBiu0x210Msg = paramView.a();
        if (localBiu0x210Msg == null) {
          continue;
        }
        l = localBiu0x210Msg.b;
        localJSONObject.put("reddot_source", l);
        localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        long l;
        localJSONException.printStackTrace();
        continue;
      }
      paramView.g();
      return;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqv
 * JD-Core Version:    0.7.0.1
 */