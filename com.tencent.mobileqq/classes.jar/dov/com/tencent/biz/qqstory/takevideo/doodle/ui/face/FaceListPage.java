package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import aekt;
import alpo;
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
import bdee;
import blmf;
import blof;
import blrz;
import bmri;
import bmrj;
import bmrk;
import bmrp;
import bmrq;
import bmrt;
import bmrx;
import bmsc;
import bmsi;
import bmsj;
import bmsm;
import bmtu;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import wsv;
import wta;

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
  private blof jdField_a_of_type_Blof;
  private bmri jdField_a_of_type_Bmri;
  private bmrj jdField_a_of_type_Bmrj;
  private bmrx jdField_a_of_type_Bmrx;
  private bmsc jdField_a_of_type_Bmsc;
  private bmsi jdField_a_of_type_Bmsi;
  private bmsj jdField_a_of_type_Bmsj;
  private bmsm jdField_a_of_type_Bmsm;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, blof paramblof, bmri parambmri)
  {
    super(paramContext);
    this.jdField_a_of_type_Bmri = parambmri;
    this.jdField_a_of_type_Blof = paramblof;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    wsv.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bmrj instanceof bmrk)) {
      return;
    }
    if (!((bmrk)this.jdField_a_of_type_Bmrj).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bmrx.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bmrj parambmrj)
  {
    if ((parambmrj instanceof bmrt))
    {
      if (this.jdField_a_of_type_Bmsm == null) {
        this.jdField_a_of_type_Bmsm = new bmsm(super.getContext(), this);
      }
      this.jdField_a_of_type_Bmrx = this.jdField_a_of_type_Bmsm;
    }
    for (;;)
    {
      if (!(parambmrj instanceof bmrp))
      {
        View localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bmtu.b(getContext(), 10.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
        localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bmtu.b(getContext(), 36.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
      }
      if (this.jdField_a_of_type_Bmrx != null)
      {
        this.jdField_a_of_type_Bmrx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bmrx.a(this.jdField_a_of_type_Blof);
        this.jdField_a_of_type_Bmrx.a(parambmrj);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bmrx);
      }
      return;
      if ((parambmrj instanceof bmrq))
      {
        if (this.jdField_a_of_type_Bmsj == null) {
          this.jdField_a_of_type_Bmsj = new bmsj(super.getContext(), this);
        }
        this.jdField_a_of_type_Bmrx = this.jdField_a_of_type_Bmsj;
      }
      else if ((parambmrj instanceof bmrk))
      {
        if (this.jdField_a_of_type_Bmsc == null) {
          this.jdField_a_of_type_Bmsc = new bmsc(super.getContext(), this);
        }
        this.jdField_a_of_type_Bmrx = this.jdField_a_of_type_Bmsc;
      }
      else if ((parambmrj instanceof bmrp))
      {
        if (this.jdField_a_of_type_Bmsi == null) {
          this.jdField_a_of_type_Bmsi = new bmsi(super.getContext(), this);
        }
        this.jdField_a_of_type_Bmrx = this.jdField_a_of_type_Bmsi;
      }
      else
      {
        wsv.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    wsv.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bmrj instanceof bmrq)) {
      return;
    }
    bmrq localbmrq = (bmrq)this.jdField_a_of_type_Bmrj;
    if (!localbmrq.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bmrx.notifyDataSetChanged();
      return;
    }
    if (localbmrq.jdField_b_of_type_Boolean)
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
    wsv.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bmrj);
    Object localObject = this.jdField_a_of_type_Bmrj;
    if (localObject == null) {}
    while (!(localObject instanceof bmrt)) {
      return;
    }
    bmrt localbmrt = (bmrt)localObject;
    if ((localbmrt.jdField_a_of_type_JavaUtilList != null) && (!localbmrt.jdField_a_of_type_JavaUtilList.isEmpty())) {
      wsv.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbmrt.g)))
      {
        wsv.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbmrt.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbmrt, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = aekt.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561424, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365949));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365950));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372312));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365936));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365929));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369794));
    this.c = ((LinearLayout)super.findViewById(2131369799));
    this.d = ((LinearLayout)super.findViewById(2131369791));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365420));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bmrj == null) {
      wsv.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bmrj.a())) {
            break;
          }
          localObject = (bmrq)this.jdField_a_of_type_Bmrj;
        } while ((!((bmrq)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bmrq)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (bdee.g(super.getContext())) {
          wta.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          wta.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bmrj.a()));
      localObject = (bmrt)this.jdField_a_of_type_Bmrj;
      ((blrz)blmf.a(14)).a(((bmrt)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!bdee.a(getContext())) || (this.jdField_a_of_type_Bmri == null) || (((bmrt)localObject).jdField_b_of_type_Boolean) || (!((bmrt)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    wsv.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bmri.a(((bmrt)localObject).jdField_a_of_type_JavaLangString);
    wta.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bmrj parambmrj)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambmrj));
    }
    do
    {
      return;
      if (parambmrj == null) {
        break;
      }
      wsv.b("FaceListPage", "onChange,FacePkgInfo:" + parambmrj.toString());
      if ((this.jdField_a_of_type_Bmrj == null) || (!this.jdField_a_of_type_Bmrj.a().equals(parambmrj.a()))) {
        b(parambmrj);
      }
      this.jdField_a_of_type_Bmrj = parambmrj;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bmrj.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bmrj.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bmrj.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bmrj.a()));
    d();
    return;
    wsv.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bmrj = null;
    this.jdField_a_of_type_Bmrx.a(null);
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
    bmrj localbmrj = this.jdField_a_of_type_Bmrj;
    int j = k;
    int m;
    int i;
    if (localbmrj != null)
    {
      m = localbmrj.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbmrj.b())
      {
        String str = localbmrj.a(i);
        wsv.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bmri != null)
      {
        ((blrz)blmf.a(14)).a(this.jdField_a_of_type_Bmrj.jdField_a_of_type_JavaLangString, 4);
        if (((bmrt)this.jdField_a_of_type_Bmrj).jdField_b_of_type_Boolean) {
          break label108;
        }
        wsv.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bmrj.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bmri.a(this.jdField_a_of_type_Bmrj.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131704676));
      }
    }
    label108:
    while ((paramView != this.c) || (this.jdField_a_of_type_Bmri == null))
    {
      return;
      this.jdField_a_of_type_Bmri.b(this.jdField_a_of_type_Bmrj.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Bmri.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */