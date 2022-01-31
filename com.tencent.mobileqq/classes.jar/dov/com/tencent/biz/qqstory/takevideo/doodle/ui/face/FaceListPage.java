package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import aepi;
import alud;
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
import bdin;
import blqr;
import blsr;
import blwl;
import bmvu;
import bmvv;
import bmvw;
import bmwb;
import bmwc;
import bmwf;
import bmwj;
import bmwo;
import bmwu;
import bmwv;
import bmwy;
import bmyg;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import wxe;
import wxj;

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
  private blsr jdField_a_of_type_Blsr;
  private bmvu jdField_a_of_type_Bmvu;
  private bmvv jdField_a_of_type_Bmvv;
  private bmwj jdField_a_of_type_Bmwj;
  private bmwo jdField_a_of_type_Bmwo;
  private bmwu jdField_a_of_type_Bmwu;
  private bmwv jdField_a_of_type_Bmwv;
  private bmwy jdField_a_of_type_Bmwy;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, blsr paramblsr, bmvu parambmvu)
  {
    super(paramContext);
    this.jdField_a_of_type_Bmvu = parambmvu;
    this.jdField_a_of_type_Blsr = paramblsr;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    wxe.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bmvv instanceof bmvw)) {
      return;
    }
    if (!((bmvw)this.jdField_a_of_type_Bmvv).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bmwj.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bmvv parambmvv)
  {
    if ((parambmvv instanceof bmwf))
    {
      if (this.jdField_a_of_type_Bmwy == null) {
        this.jdField_a_of_type_Bmwy = new bmwy(super.getContext(), this);
      }
      this.jdField_a_of_type_Bmwj = this.jdField_a_of_type_Bmwy;
    }
    for (;;)
    {
      if (!(parambmvv instanceof bmwb))
      {
        View localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bmyg.b(getContext(), 10.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
        localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bmyg.b(getContext(), 36.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
      }
      if (this.jdField_a_of_type_Bmwj != null)
      {
        this.jdField_a_of_type_Bmwj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bmwj.a(this.jdField_a_of_type_Blsr);
        this.jdField_a_of_type_Bmwj.a(parambmvv);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bmwj);
      }
      return;
      if ((parambmvv instanceof bmwc))
      {
        if (this.jdField_a_of_type_Bmwv == null) {
          this.jdField_a_of_type_Bmwv = new bmwv(super.getContext(), this);
        }
        this.jdField_a_of_type_Bmwj = this.jdField_a_of_type_Bmwv;
      }
      else if ((parambmvv instanceof bmvw))
      {
        if (this.jdField_a_of_type_Bmwo == null) {
          this.jdField_a_of_type_Bmwo = new bmwo(super.getContext(), this);
        }
        this.jdField_a_of_type_Bmwj = this.jdField_a_of_type_Bmwo;
      }
      else if ((parambmvv instanceof bmwb))
      {
        if (this.jdField_a_of_type_Bmwu == null) {
          this.jdField_a_of_type_Bmwu = new bmwu(super.getContext(), this);
        }
        this.jdField_a_of_type_Bmwj = this.jdField_a_of_type_Bmwu;
      }
      else
      {
        wxe.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    wxe.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bmvv instanceof bmwc)) {
      return;
    }
    bmwc localbmwc = (bmwc)this.jdField_a_of_type_Bmvv;
    if (!localbmwc.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bmwj.notifyDataSetChanged();
      return;
    }
    if (localbmwc.jdField_b_of_type_Boolean)
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
    wxe.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bmvv);
    Object localObject = this.jdField_a_of_type_Bmvv;
    if (localObject == null) {}
    while (!(localObject instanceof bmwf)) {
      return;
    }
    bmwf localbmwf = (bmwf)localObject;
    if ((localbmwf.jdField_a_of_type_JavaUtilList != null) && (!localbmwf.jdField_a_of_type_JavaUtilList.isEmpty())) {
      wxe.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbmwf.g)))
      {
        wxe.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbmwf.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbmwf, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = aepi.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561442, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365951));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365952));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372332));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365938));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365931));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369813));
    this.c = ((LinearLayout)super.findViewById(2131369818));
    this.d = ((LinearLayout)super.findViewById(2131369810));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365422));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bmvv == null) {
      wxe.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bmvv.a())) {
            break;
          }
          localObject = (bmwc)this.jdField_a_of_type_Bmvv;
        } while ((!((bmwc)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bmwc)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (bdin.g(super.getContext())) {
          wxj.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          wxj.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bmvv.a()));
      localObject = (bmwf)this.jdField_a_of_type_Bmvv;
      ((blwl)blqr.a(14)).a(((bmwf)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!bdin.a(getContext())) || (this.jdField_a_of_type_Bmvu == null) || (((bmwf)localObject).jdField_b_of_type_Boolean) || (!((bmwf)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    wxe.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bmvu.a(((bmwf)localObject).jdField_a_of_type_JavaLangString);
    wxj.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bmvv parambmvv)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambmvv));
    }
    do
    {
      return;
      if (parambmvv == null) {
        break;
      }
      wxe.b("FaceListPage", "onChange,FacePkgInfo:" + parambmvv.toString());
      if ((this.jdField_a_of_type_Bmvv == null) || (!this.jdField_a_of_type_Bmvv.a().equals(parambmvv.a()))) {
        b(parambmvv);
      }
      this.jdField_a_of_type_Bmvv = parambmvv;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bmvv.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bmvv.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bmvv.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bmvv.a()));
    d();
    return;
    wxe.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bmvv = null;
    this.jdField_a_of_type_Bmwj.a(null);
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
    bmvv localbmvv = this.jdField_a_of_type_Bmvv;
    int j = k;
    int m;
    int i;
    if (localbmvv != null)
    {
      m = localbmvv.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbmvv.b())
      {
        String str = localbmvv.a(i);
        wxe.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bmvu != null)
      {
        ((blwl)blqr.a(14)).a(this.jdField_a_of_type_Bmvv.jdField_a_of_type_JavaLangString, 4);
        if (((bmwf)this.jdField_a_of_type_Bmvv).jdField_b_of_type_Boolean) {
          break label108;
        }
        wxe.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bmvv.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bmvu.a(this.jdField_a_of_type_Bmvv.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131704688));
      }
    }
    label108:
    while ((paramView != this.c) || (this.jdField_a_of_type_Bmvu == null))
    {
      return;
      this.jdField_a_of_type_Bmvu.b(this.jdField_a_of_type_Bmvv.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Bmvu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */