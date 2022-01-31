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

public class qjf
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<qjh> jdField_a_of_type_JavaUtilArrayList;
  private qma jdField_a_of_type_Qma;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public qjf(Context paramContext)
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
      if (qlp.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bbfr.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(qql paramqql)
  {
    return (paramqql != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqql.jdField_a_of_type_Qbt != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.j != null))
    {
      localResources = this.jdField_a_of_type_Qma.j.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Qma.jdField_a_of_type_Qql == null) || (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130842511;
        if (localResources.getText(2131718462).toString().equals(localObject1)) {
          i = 2130842510;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Qma.j.setText((CharSequence)localObject1);
      int j = actj.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Qma.j.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131718467).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718462).toString();
      break;
      localObject1 = localResources.getText(2131718464).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718505).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131718505).toString();
      break;
      if (localResources.getText(2131718464).toString().equals(localObject1)) {
        i = 2130842513;
      }
    }
  }
  
  public qma a()
  {
    return this.jdField_a_of_type_Qma;
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
    if (this.jdField_a_of_type_Qma != null) {
      this.jdField_a_of_type_Qma = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(qjh paramqjh)
  {
    if ((paramqjh != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramqjh))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramqjh);
    }
  }
  
  public void a(qmp paramqmp)
  {
    if (this.jdField_a_of_type_Qma != null)
    {
      this.jdField_a_of_type_Qma.g.setVisibility(8);
      this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramqmp instanceof qma))
    {
      this.jdField_a_of_type_Qma = ((qma)paramqmp);
      return;
    }
    this.jdField_a_of_type_Qma = null;
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.g != null) && (this.jdField_a_of_type_Qma.g.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Qma.g.setVisibility(8);
        this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(qql paramqql)
  {
    if ((paramqql == null) || (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Qma != null) && (!this.jdField_a_of_type_Boolean) && (oaq.b(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Qma == null) || (this.jdField_a_of_type_Boolean) || (!oaq.a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    qbt localqbt;
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
    if ((b(paramqql)) && (paramqql.jdField_a_of_type_Qty != null) && (!paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Boolean))
    {
      if (paramqql.jdField_a_of_type_Qty.e() != 0L) {
        break label496;
      }
      paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Int = paramqql.jdField_a_of_type_Qbt.e;
      paramqql.jdField_a_of_type_Qbt.e = ((int)paramqql.jdField_a_of_type_Qty.b(true));
      localqbt = paramqql.jdField_a_of_type_Qbt;
      if (paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localqbt.b = bool;
      paramqql.jdField_a_of_type_Qbt.c = true;
      paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Boolean = true;
      localqbt = paramqql.jdField_a_of_type_Qbt;
      localAdvertisementInfo = nmc.a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localqbt.jdField_d_of_type_Int;
      n = localqbt.e;
      if (!localqbt.b) {
        break label520;
      }
      i = 1;
      if (!localqbt.c) {
        break label525;
      }
      j = 1;
      i1 = localqbt.f;
      if (!localqbt.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = nmc.a(m, n, i, j, i1, k, (int)paramqql.jdField_a_of_type_Qty.b(), nmc.aE, 0);
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.f).b(localqbt.g).a(localAdvertisementInfo).a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Qma.g != null)
      {
        this.jdField_a_of_type_Qma.g.setVisibility(0);
        this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a("continue_pause", true);
        if (this.jdField_a_of_type_Qma.h != null) {
          this.jdField_a_of_type_Qma.h.setVisibility(8);
        }
        paramqql = ObjectAnimator.ofFloat(this.jdField_a_of_type_Qma.g, "alpha", new float[] { 0.0F, 1.0F });
        paramqql.setDuration(200L);
        paramqql.setInterpolator(new DecelerateInterpolator());
        paramqql.addListener(new qjg(this));
        paramqql.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Int = ((int)paramqql.jdField_a_of_type_Qty.e());
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
    if ((this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.g != null))
    {
      this.jdField_a_of_type_Qma.g.setVisibility(8);
      this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
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
    if ((this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Qma.g != null)
      {
        this.jdField_a_of_type_Qma.g.setVisibility(8);
        this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((qjh)paramMessage.next()).a();
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
 * Qualified Name:     qjf
 * JD-Core Version:    0.7.0.1
 */