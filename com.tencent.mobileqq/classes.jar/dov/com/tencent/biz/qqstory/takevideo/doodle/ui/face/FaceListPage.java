package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import actj;
import ajya;
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
import bbfj;
import bjav;
import bjcu;
import bjgo;
import bkfy;
import bkfz;
import bkga;
import bkgf;
import bkgg;
import bkgj;
import bkgn;
import bkgs;
import bkgy;
import bkgz;
import bkhc;
import bkik;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import ved;
import vei;

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
  private bjcu jdField_a_of_type_Bjcu;
  private bkfy jdField_a_of_type_Bkfy;
  private bkfz jdField_a_of_type_Bkfz;
  private bkgn jdField_a_of_type_Bkgn;
  private bkgs jdField_a_of_type_Bkgs;
  private bkgy jdField_a_of_type_Bkgy;
  private bkgz jdField_a_of_type_Bkgz;
  private bkhc jdField_a_of_type_Bkhc;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, bjcu parambjcu, bkfy parambkfy)
  {
    super(paramContext);
    this.jdField_a_of_type_Bkfy = parambkfy;
    this.jdField_a_of_type_Bjcu = parambjcu;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    ved.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bkfz instanceof bkga)) {
      return;
    }
    if (!((bkga)this.jdField_a_of_type_Bkfz).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bkgn.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bkfz parambkfz)
  {
    if ((parambkfz instanceof bkgj))
    {
      if (this.jdField_a_of_type_Bkhc == null) {
        this.jdField_a_of_type_Bkhc = new bkhc(super.getContext(), this);
      }
      this.jdField_a_of_type_Bkgn = this.jdField_a_of_type_Bkhc;
      if (!(parambkfz instanceof bkgf)) {
        break label227;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkgn != null)
      {
        this.jdField_a_of_type_Bkgn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bkgn.a(this.jdField_a_of_type_Bjcu);
        this.jdField_a_of_type_Bkgn.a(parambkfz);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bkgn);
      }
      return;
      if ((parambkfz instanceof bkgg))
      {
        if (this.jdField_a_of_type_Bkgz == null) {
          this.jdField_a_of_type_Bkgz = new bkgz(super.getContext(), this);
        }
        this.jdField_a_of_type_Bkgn = this.jdField_a_of_type_Bkgz;
        break;
      }
      if ((parambkfz instanceof bkga))
      {
        if (this.jdField_a_of_type_Bkgs == null) {
          this.jdField_a_of_type_Bkgs = new bkgs(super.getContext(), this);
        }
        this.jdField_a_of_type_Bkgn = this.jdField_a_of_type_Bkgs;
        break;
      }
      if ((parambkfz instanceof bkgf))
      {
        if (this.jdField_a_of_type_Bkgy == null) {
          this.jdField_a_of_type_Bkgy = new bkgy(super.getContext(), this);
        }
        this.jdField_a_of_type_Bkgn = this.jdField_a_of_type_Bkgy;
        break;
      }
      ved.e("FaceListPage", "FacePackage is illegal.");
      break;
      label227:
      View localView = new View(getContext());
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, bkik.a(getContext(), 10.0F)));
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
      localView = new View(getContext());
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, bkik.a(getContext(), 36.0F)));
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
    }
  }
  
  private void c()
  {
    ved.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bkfz instanceof bkgg)) {
      return;
    }
    bkgg localbkgg = (bkgg)this.jdField_a_of_type_Bkfz;
    if (!localbkgg.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bkgn.notifyDataSetChanged();
      return;
    }
    if (localbkgg.jdField_b_of_type_Boolean)
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
    ved.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bkfz);
    Object localObject = this.jdField_a_of_type_Bkfz;
    if (localObject == null) {}
    while (!(localObject instanceof bkgj)) {
      return;
    }
    bkgj localbkgj = (bkgj)localObject;
    if ((localbkgj.jdField_a_of_type_JavaUtilList != null) && (!localbkgj.jdField_a_of_type_JavaUtilList.isEmpty())) {
      ved.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbkgj.g)))
      {
        ved.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbkgj.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbkgj, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = actj.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561234, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365864));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131371995));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365850));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365843));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369532));
    this.c = ((LinearLayout)super.findViewById(2131369537));
    this.d = ((LinearLayout)super.findViewById(2131369529));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365335));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkfz == null) {
      ved.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bkfz.a())) {
            break;
          }
          localObject = (bkgg)this.jdField_a_of_type_Bkfz;
        } while ((!((bkgg)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bkgg)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (bbfj.g(super.getContext())) {
          vei.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          vei.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bkfz.a()));
      localObject = (bkgj)this.jdField_a_of_type_Bkfz;
      ((bjgo)bjav.a(14)).a(((bkgj)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!bbfj.a(getContext())) || (this.jdField_a_of_type_Bkfy == null) || (((bkgj)localObject).jdField_b_of_type_Boolean) || (!((bkgj)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    ved.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bkfy.a(((bkgj)localObject).jdField_a_of_type_JavaLangString);
    vei.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bkfz parambkfz)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambkfz));
    }
    do
    {
      return;
      if (parambkfz == null) {
        break;
      }
      ved.b("FaceListPage", "onChange,FacePkgInfo:" + parambkfz.toString());
      if ((this.jdField_a_of_type_Bkfz == null) || (!this.jdField_a_of_type_Bkfz.a().equals(parambkfz.a()))) {
        b(parambkfz);
      }
      this.jdField_a_of_type_Bkfz = parambkfz;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bkfz.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bkfz.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bkfz.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bkfz.a()));
    d();
    return;
    ved.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bkfz = null;
    this.jdField_a_of_type_Bkgn.a(null);
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
    bkfz localbkfz = this.jdField_a_of_type_Bkfz;
    int j = k;
    int m;
    int i;
    if (localbkfz != null)
    {
      m = localbkfz.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbkfz.b())
      {
        String str = localbkfz.a(i);
        ved.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bkfy != null)
      {
        ((bjgo)bjav.a(14)).a(this.jdField_a_of_type_Bkfz.jdField_a_of_type_JavaLangString, 4);
        if (((bkgj)this.jdField_a_of_type_Bkfz).jdField_b_of_type_Boolean) {
          break label108;
        }
        ved.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bkfz.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bkfy.a(this.jdField_a_of_type_Bkfz.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131704304));
      }
    }
    label108:
    while ((paramView != this.c) || (this.jdField_a_of_type_Bkfy == null))
    {
      return;
      this.jdField_a_of_type_Bkfy.b(this.jdField_a_of_type_Bkfz.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Bkfy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */