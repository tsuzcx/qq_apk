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

public class pxk
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<pxm> jdField_a_of_type_JavaUtilArrayList;
  private qab jdField_a_of_type_Qab;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public pxk(Context paramContext)
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
      if (pzs.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bady.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(qeq paramqeq)
  {
    return (paramqeq != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqeq.jdField_a_of_type_Pqa != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.j != null))
    {
      localResources = this.jdField_a_of_type_Qab.j.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq == null) || (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130842436;
        if (localResources.getText(2131652632).toString().equals(localObject1)) {
          i = 2130842435;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Qab.j.setText((CharSequence)localObject1);
      int j = aciy.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Qab.j.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131652637).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131652632).toString();
      break;
      localObject1 = localResources.getText(2131652634).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131652671).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131652671).toString();
      break;
      if (localResources.getText(2131652634).toString().equals(localObject1)) {
        i = 2130842438;
      }
    }
  }
  
  public qab a()
  {
    return this.jdField_a_of_type_Qab;
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
    if (this.jdField_a_of_type_Qab != null) {
      this.jdField_a_of_type_Qab = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(pxm parampxm)
  {
    if ((parampxm != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parampxm))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parampxm);
    }
  }
  
  public void a(qaq paramqaq)
  {
    if (this.jdField_a_of_type_Qab != null)
    {
      this.jdField_a_of_type_Qab.g.setVisibility(8);
      this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramqaq instanceof qab))
    {
      this.jdField_a_of_type_Qab = ((qab)paramqaq);
      return;
    }
    this.jdField_a_of_type_Qab = null;
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.g != null) && (this.jdField_a_of_type_Qab.g.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Qab.g.setVisibility(8);
        this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(qeq paramqeq)
  {
    if ((paramqeq == null) || (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Qab != null) && (!this.jdField_a_of_type_Boolean) && (npi.b(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Qab == null) || (this.jdField_a_of_type_Boolean) || (!npi.a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    pqa localpqa;
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
    if ((b(paramqeq)) && (paramqeq.jdField_a_of_type_Qhw != null) && (!paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Boolean))
    {
      if (paramqeq.jdField_a_of_type_Qhw.d() != 0L) {
        break label496;
      }
      paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int = paramqeq.jdField_a_of_type_Pqa.e;
      paramqeq.jdField_a_of_type_Pqa.e = ((int)paramqeq.jdField_a_of_type_Qhw.b(true));
      localpqa = paramqeq.jdField_a_of_type_Pqa;
      if (paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localpqa.b = bool;
      paramqeq.jdField_a_of_type_Pqa.c = true;
      paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Boolean = true;
      localpqa = paramqeq.jdField_a_of_type_Pqa;
      localAdvertisementInfo = nbe.a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localpqa.jdField_d_of_type_Int;
      n = localpqa.e;
      if (!localpqa.b) {
        break label520;
      }
      i = 1;
      if (!localpqa.c) {
        break label525;
      }
      j = 1;
      i1 = localpqa.f;
      if (!localpqa.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = nbe.a(m, n, i, j, i1, k, (int)paramqeq.jdField_a_of_type_Qhw.b(), nbe.aD, 0);
      nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.f).b(localpqa.g).a(localAdvertisementInfo).a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Qab.g != null)
      {
        this.jdField_a_of_type_Qab.g.setVisibility(0);
        this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a("continue_pause", true);
        if (this.jdField_a_of_type_Qab.h != null) {
          this.jdField_a_of_type_Qab.h.setVisibility(8);
        }
        paramqeq = ObjectAnimator.ofFloat(this.jdField_a_of_type_Qab.g, "alpha", new float[] { 0.0F, 1.0F });
        paramqeq.setDuration(200L);
        paramqeq.setInterpolator(new DecelerateInterpolator());
        paramqeq.addListener(new pxl(this));
        paramqeq.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int = ((int)paramqeq.jdField_a_of_type_Qhw.d());
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
    if ((this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.g != null))
    {
      this.jdField_a_of_type_Qab.g.setVisibility(8);
      this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
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
    if ((this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Qab.g != null)
      {
        this.jdField_a_of_type_Qab.g.setVisibility(8);
        this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((pxm)paramMessage.next()).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxk
 * JD-Core Version:    0.7.0.1
 */