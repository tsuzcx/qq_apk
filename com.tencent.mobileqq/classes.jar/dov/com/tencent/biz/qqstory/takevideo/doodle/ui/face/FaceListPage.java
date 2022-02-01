package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import bogd;
import boid;
import boki;
import bpav;
import bpaw;
import bpax;
import bpbc;
import bpbf;
import bpbj;
import bpbo;
import bpbu;
import bpbx;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import ykq;
import ykv;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boid jdField_a_of_type_Boid;
  private bpav jdField_a_of_type_Bpav;
  private bpaw jdField_a_of_type_Bpaw;
  private bpbj jdField_a_of_type_Bpbj;
  private bpbo jdField_a_of_type_Bpbo;
  private bpbu jdField_a_of_type_Bpbu;
  private bpbx jdField_a_of_type_Bpbx;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, boid paramboid, bpav parambpav)
  {
    super(paramContext);
    this.jdField_a_of_type_Bpav = parambpav;
    this.jdField_a_of_type_Boid = paramboid;
    e();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    ykq.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bpaw instanceof bpax)) {
      return;
    }
    if (!((bpax)this.jdField_a_of_type_Bpaw).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bpbj.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bpaw parambpaw)
  {
    if ((parambpaw instanceof bpbf))
    {
      if (this.jdField_a_of_type_Bpbx == null) {
        this.jdField_a_of_type_Bpbx = new bpbx(super.getContext(), this);
      }
      this.jdField_a_of_type_Bpbj = this.jdField_a_of_type_Bpbx;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bpbj != null)
      {
        this.jdField_a_of_type_Bpbj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bpbj.a(this.jdField_a_of_type_Boid);
        this.jdField_a_of_type_Bpbj.a(parambpaw);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bpbj);
      }
      return;
      if ((parambpaw instanceof bpbc))
      {
        if (this.jdField_a_of_type_Bpbu == null) {
          this.jdField_a_of_type_Bpbu = new bpbu(super.getContext(), this);
        }
        this.jdField_a_of_type_Bpbj = this.jdField_a_of_type_Bpbu;
      }
      else if ((parambpaw instanceof bpax))
      {
        if (this.jdField_a_of_type_Bpbo == null) {
          this.jdField_a_of_type_Bpbo = new bpbo(super.getContext(), this);
        }
        this.jdField_a_of_type_Bpbj = this.jdField_a_of_type_Bpbo;
      }
      else
      {
        ykq.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    ykq.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bpaw instanceof bpbc)) {
      return;
    }
    bpbc localbpbc = (bpbc)this.jdField_a_of_type_Bpaw;
    if (!localbpbc.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bpbj.notifyDataSetChanged();
      return;
    }
    if (localbpbc.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.c.setVisibility(4);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void d()
  {
    boolean bool2 = true;
    ykq.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bpaw);
    Object localObject = this.jdField_a_of_type_Bpaw;
    if (localObject == null) {}
    while (!(localObject instanceof bpbf)) {
      return;
    }
    bpbf localbpbf = (bpbf)localObject;
    if ((localbpbf.jdField_a_of_type_JavaUtilList != null) && (!localbpbf.jdField_a_of_type_JavaUtilList.isEmpty())) {
      ykq.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbpbf.g)))
      {
        ykq.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbpbf.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbpbf, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_Int = AIOUtils.dp2px(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561665, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366382));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366383));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373219));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366369));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366363));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370499));
    this.c = ((LinearLayout)super.findViewById(2131370505));
    this.d = ((LinearLayout)super.findViewById(2131370495));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365827));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bpaw == null) {
      ykq.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bpaw.a())) {
            break;
          }
          localObject = (bpbc)this.jdField_a_of_type_Bpaw;
        } while ((!((bpbc)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bpbc)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (NetworkUtil.isNetworkAvailable(super.getContext())) {
          ykv.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          ykv.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bpaw.a()));
      localObject = (bpbf)this.jdField_a_of_type_Bpaw;
      ((boki)bogd.a(14)).a(((bpbf)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!NetworkUtil.isWifiEnabled(getContext())) || (this.jdField_a_of_type_Bpav == null) || (((bpbf)localObject).jdField_b_of_type_Boolean) || (!((bpbf)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    ykq.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bpav.a(((bpbf)localObject).jdField_a_of_type_JavaLangString);
    ykv.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bpaw parambpaw)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambpaw));
    }
    do
    {
      return;
      if (parambpaw == null) {
        break;
      }
      ykq.b("FaceListPage", "onChange,FacePkgInfo:" + parambpaw.toString());
      if ((this.jdField_a_of_type_Bpaw == null) || (!this.jdField_a_of_type_Bpaw.a().equals(parambpaw.a()))) {
        b(parambpaw);
      }
      this.jdField_a_of_type_Bpaw = parambpaw;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bpaw.a()))
      {
        d();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bpaw.a()))
      {
        c();
        return;
      }
    } while (!"InformationFacePackage".equals(this.jdField_a_of_type_Bpaw.a()));
    b();
    return;
    ykq.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bpaw = null;
    this.jdField_a_of_type_Bpbj.a(null);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    bpaw localbpaw = this.jdField_a_of_type_Bpaw;
    int j = k;
    int m;
    int i;
    if (localbpaw != null)
    {
      m = localbpaw.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbpaw.b())
      {
        String str = localbpaw.a(i);
        ykq.b("FaceListPage", "selectByName : " + paramString + str);
        if ((str != null) && (str.contains(paramString))) {
          j = i / m;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetListView.setSelection(j);
        return;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      if (this.jdField_a_of_type_Bpav != null)
      {
        ((boki)bogd.a(14)).a(this.jdField_a_of_type_Bpaw.jdField_a_of_type_JavaLangString, 4);
        if (((bpbf)this.jdField_a_of_type_Bpaw).jdField_b_of_type_Boolean) {
          break label115;
        }
        ykq.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bpaw.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bpav.a(this.jdField_a_of_type_Bpaw.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131703773));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      this.jdField_a_of_type_Bpav.b(this.jdField_a_of_type_Bpaw.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Bpav != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Bpav.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */