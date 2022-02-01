package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import afur;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anni;
import bgnt;
import bojv;
import bolv;
import bopp;
import bpna;
import bpnb;
import bpnc;
import bpnh;
import bpni;
import bpnl;
import bpnp;
import bpnu;
import bpoa;
import bpob;
import bpoe;
import bppm;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import yqp;
import yqu;

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
  private bolv jdField_a_of_type_Bolv;
  private bpna jdField_a_of_type_Bpna;
  private bpnb jdField_a_of_type_Bpnb;
  private bpnp jdField_a_of_type_Bpnp;
  private bpnu jdField_a_of_type_Bpnu;
  private bpoa jdField_a_of_type_Bpoa;
  private bpob jdField_a_of_type_Bpob;
  private bpoe jdField_a_of_type_Bpoe;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, bolv parambolv, bpna parambpna)
  {
    super(paramContext);
    this.jdField_a_of_type_Bpna = parambpna;
    this.jdField_a_of_type_Bolv = parambolv;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    yqp.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bpnb instanceof bpnc)) {
      return;
    }
    if (!((bpnc)this.jdField_a_of_type_Bpnb).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bpnp.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bpnb parambpnb)
  {
    if ((parambpnb instanceof bpnl))
    {
      if (this.jdField_a_of_type_Bpoe == null) {
        this.jdField_a_of_type_Bpoe = new bpoe(super.getContext(), this);
      }
      this.jdField_a_of_type_Bpnp = this.jdField_a_of_type_Bpoe;
    }
    for (;;)
    {
      if (!(parambpnb instanceof bpnh))
      {
        View localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bppm.b(getContext(), 10.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
        localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bppm.b(getContext(), 36.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
      }
      if (this.jdField_a_of_type_Bpnp != null)
      {
        this.jdField_a_of_type_Bpnp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bpnp.a(this.jdField_a_of_type_Bolv);
        this.jdField_a_of_type_Bpnp.a(parambpnb);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bpnp);
      }
      return;
      if ((parambpnb instanceof bpni))
      {
        if (this.jdField_a_of_type_Bpob == null) {
          this.jdField_a_of_type_Bpob = new bpob(super.getContext(), this);
        }
        this.jdField_a_of_type_Bpnp = this.jdField_a_of_type_Bpob;
      }
      else if ((parambpnb instanceof bpnc))
      {
        if (this.jdField_a_of_type_Bpnu == null) {
          this.jdField_a_of_type_Bpnu = new bpnu(super.getContext(), this);
        }
        this.jdField_a_of_type_Bpnp = this.jdField_a_of_type_Bpnu;
      }
      else if ((parambpnb instanceof bpnh))
      {
        if (this.jdField_a_of_type_Bpoa == null) {
          this.jdField_a_of_type_Bpoa = new bpoa(super.getContext(), this);
        }
        this.jdField_a_of_type_Bpnp = this.jdField_a_of_type_Bpoa;
      }
      else
      {
        yqp.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    yqp.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bpnb instanceof bpni)) {
      return;
    }
    bpni localbpni = (bpni)this.jdField_a_of_type_Bpnb;
    if (!localbpni.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bpnp.notifyDataSetChanged();
      return;
    }
    if (localbpni.jdField_b_of_type_Boolean)
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
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
  }
  
  private void e()
  {
    boolean bool2 = true;
    yqp.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bpnb);
    Object localObject = this.jdField_a_of_type_Bpnb;
    if (localObject == null) {}
    while (!(localObject instanceof bpnl)) {
      return;
    }
    bpnl localbpnl = (bpnl)localObject;
    if ((localbpnl.jdField_a_of_type_JavaUtilList != null) && (!localbpnl.jdField_a_of_type_JavaUtilList.isEmpty())) {
      yqp.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbpnl.g)))
      {
        yqp.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbpnl.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbpnl, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = afur.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561678, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366202));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366203));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372926));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366189));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366183));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370250));
    this.c = ((LinearLayout)super.findViewById(2131370255));
    this.d = ((LinearLayout)super.findViewById(2131370247));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365657));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bpnb == null) {
      yqp.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bpnb.a())) {
            break;
          }
          localObject = (bpni)this.jdField_a_of_type_Bpnb;
        } while ((!((bpni)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bpni)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (bgnt.g(super.getContext())) {
          yqu.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          yqu.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bpnb.a()));
      localObject = (bpnl)this.jdField_a_of_type_Bpnb;
      ((bopp)bojv.a(14)).a(((bpnl)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!bgnt.a(getContext())) || (this.jdField_a_of_type_Bpna == null) || (((bpnl)localObject).jdField_b_of_type_Boolean) || (!((bpnl)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    yqp.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bpna.a(((bpnl)localObject).jdField_a_of_type_JavaLangString);
    yqu.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bpnb parambpnb)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambpnb));
    }
    do
    {
      return;
      if (parambpnb == null) {
        break;
      }
      yqp.b("FaceListPage", "onChange,FacePkgInfo:" + parambpnb.toString());
      if ((this.jdField_a_of_type_Bpnb == null) || (!this.jdField_a_of_type_Bpnb.a().equals(parambpnb.a()))) {
        b(parambpnb);
      }
      this.jdField_a_of_type_Bpnb = parambpnb;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bpnb.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bpnb.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bpnb.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bpnb.a()));
    d();
    return;
    yqp.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bpnb = null;
    this.jdField_a_of_type_Bpnp.a(null);
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
    bpnb localbpnb = this.jdField_a_of_type_Bpnb;
    int j = k;
    int m;
    int i;
    if (localbpnb != null)
    {
      m = localbpnb.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbpnb.b())
      {
        String str = localbpnb.a(i);
        yqp.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bpna != null)
      {
        ((bopp)bojv.a(14)).a(this.jdField_a_of_type_Bpnb.jdField_a_of_type_JavaLangString, 4);
        if (((bpnl)this.jdField_a_of_type_Bpnb).jdField_b_of_type_Boolean) {
          break label115;
        }
        yqp.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bpnb.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bpna.a(this.jdField_a_of_type_Bpnb.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131703085));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      this.jdField_a_of_type_Bpna.b(this.jdField_a_of_type_Bpnb.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Bpna != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Bpna.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */