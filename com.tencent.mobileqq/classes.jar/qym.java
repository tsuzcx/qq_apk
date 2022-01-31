import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class qym
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<qyo> jdField_a_of_type_JavaUtilArrayList;
  private rbi jdField_a_of_type_Rbi;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public qym(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    int i = 2;
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (raw.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bdem.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(rfs paramrfs)
  {
    return (paramrfs != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrfs.jdField_a_of_type_Qlp != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.j != null))
    {
      localResources = this.jdField_a_of_type_Rbi.j.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs == null) || (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130842688;
        if (localResources.getText(2131718891).toString().equals(localObject1)) {
          i = 2130842687;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rbi.j.setText((CharSequence)localObject1);
      int j = aekt.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Rbi.j.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131718896).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718891).toString();
      break;
      localObject1 = localResources.getText(2131718893).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718941).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131718941).toString();
      break;
      if (localResources.getText(2131718893).toString().equals(localObject1)) {
        i = 2130842690;
      }
    }
  }
  
  public rbi a()
  {
    return this.jdField_a_of_type_Rbi;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_Rbi != null) {
      this.jdField_a_of_type_Rbi = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(qyo paramqyo)
  {
    if ((paramqyo != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramqyo))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramqyo);
    }
  }
  
  public void a(rbt paramrbt)
  {
    if (this.jdField_a_of_type_Rbi != null)
    {
      this.jdField_a_of_type_Rbi.g.setVisibility(8);
      this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramrbt instanceof rbi))
    {
      this.jdField_a_of_type_Rbi = ((rbi)paramrbt);
      return;
    }
    this.jdField_a_of_type_Rbi = null;
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.g != null) && (this.jdField_a_of_type_Rbi.g.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Rbi.g.setVisibility(8);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(rfs paramrfs)
  {
    if ((paramrfs == null) || (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Rbi != null) && (!this.jdField_a_of_type_Boolean) && (oed.b(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Rbi == null) || (this.jdField_a_of_type_Boolean) || (!oed.a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    qlp localqlp;
    boolean bool;
    label163:
    AdvertisementInfo localAdvertisementInfo;
    int m;
    int n;
    int i;
    label228:
    int j;
    label238:
    int i1;
    if ((b(paramrfs)) && (paramrfs.jdField_a_of_type_Rjn != null) && (!paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Boolean))
    {
      if (paramrfs.jdField_a_of_type_Rjn.e() != 0L) {
        break label496;
      }
      paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int = paramrfs.jdField_a_of_type_Qlp.e;
      paramrfs.jdField_a_of_type_Qlp.e = ((int)paramrfs.jdField_a_of_type_Rjn.b(true));
      localqlp = paramrfs.jdField_a_of_type_Qlp;
      if (paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localqlp.b = bool;
      paramrfs.jdField_a_of_type_Qlp.c = true;
      paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Boolean = true;
      localqlp = paramrfs.jdField_a_of_type_Qlp;
      localAdvertisementInfo = noy.a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localqlp.jdField_d_of_type_Int;
      n = localqlp.e;
      if (!localqlp.b) {
        break label520;
      }
      i = 1;
      if (!localqlp.c) {
        break label525;
      }
      j = 1;
      i1 = localqlp.f;
      if (!localqlp.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = noy.a(m, n, i, j, i1, k, (int)paramrfs.jdField_a_of_type_Rjn.b(), noy.aE, 0);
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.f).b(localqlp.g).a(localAdvertisementInfo).a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Rbi.g != null)
      {
        this.jdField_a_of_type_Rbi.g.setVisibility(0);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a("continue_pause", true);
        if (this.jdField_a_of_type_Rbi.h != null) {
          this.jdField_a_of_type_Rbi.h.setVisibility(8);
        }
        paramrfs = ObjectAnimator.ofFloat(this.jdField_a_of_type_Rbi.g, "alpha", new float[] { 0.0F, 1.0F });
        paramrfs.setDuration(200L);
        paramrfs.setInterpolator(new DecelerateInterpolator());
        paramrfs.addListener(new qyn(this));
        paramrfs.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int = ((int)paramrfs.jdField_a_of_type_Rjn.e());
      break;
      bool = false;
      break label163;
      i = 0;
      break label228;
      j = 0;
      break label238;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.b = true;
    b();
  }
  
  public void d()
  {
    this.b = false;
    a();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.g != null))
    {
      this.jdField_a_of_type_Rbi.g.setVisibility(8);
      this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
      this.c = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Rbi.g != null)
      {
        this.jdField_a_of_type_Rbi.g.setVisibility(8);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((qyo)paramMessage.next()).a();
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return true;
      label154:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qym
 * JD-Core Version:    0.7.0.1
 */