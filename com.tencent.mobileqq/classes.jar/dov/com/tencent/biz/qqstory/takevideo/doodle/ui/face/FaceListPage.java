package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import aciy;
import ajjy;
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
import badq;
import bhfm;
import bhhl;
import bhlf;
import biom;
import bion;
import bioo;
import biot;
import biou;
import biox;
import bipb;
import bipg;
import bipm;
import bipn;
import bipq;
import biqy;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import urk;
import urp;

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
  private bhhl jdField_a_of_type_Bhhl;
  private biom jdField_a_of_type_Biom;
  private bion jdField_a_of_type_Bion;
  private bipb jdField_a_of_type_Bipb;
  private bipg jdField_a_of_type_Bipg;
  private bipm jdField_a_of_type_Bipm;
  private bipn jdField_a_of_type_Bipn;
  private bipq jdField_a_of_type_Bipq;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, bhhl parambhhl, biom parambiom)
  {
    super(paramContext);
    this.jdField_a_of_type_Biom = parambiom;
    this.jdField_a_of_type_Bhhl = parambhhl;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    urk.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bion instanceof bioo)) {
      return;
    }
    if (!((bioo)this.jdField_a_of_type_Bion).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bipb.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bion parambion)
  {
    if ((parambion instanceof biox))
    {
      if (this.jdField_a_of_type_Bipq == null) {
        this.jdField_a_of_type_Bipq = new bipq(super.getContext(), this);
      }
      this.jdField_a_of_type_Bipb = this.jdField_a_of_type_Bipq;
      if (!(parambion instanceof biot)) {
        break label227;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bipb != null)
      {
        this.jdField_a_of_type_Bipb.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bipb.a(this.jdField_a_of_type_Bhhl);
        this.jdField_a_of_type_Bipb.a(parambion);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bipb);
      }
      return;
      if ((parambion instanceof biou))
      {
        if (this.jdField_a_of_type_Bipn == null) {
          this.jdField_a_of_type_Bipn = new bipn(super.getContext(), this);
        }
        this.jdField_a_of_type_Bipb = this.jdField_a_of_type_Bipn;
        break;
      }
      if ((parambion instanceof bioo))
      {
        if (this.jdField_a_of_type_Bipg == null) {
          this.jdField_a_of_type_Bipg = new bipg(super.getContext(), this);
        }
        this.jdField_a_of_type_Bipb = this.jdField_a_of_type_Bipg;
        break;
      }
      if ((parambion instanceof biot))
      {
        if (this.jdField_a_of_type_Bipm == null) {
          this.jdField_a_of_type_Bipm = new bipm(super.getContext(), this);
        }
        this.jdField_a_of_type_Bipb = this.jdField_a_of_type_Bipm;
        break;
      }
      urk.e("FaceListPage", "FacePackage is illegal.");
      break;
      label227:
      View localView = new View(getContext());
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, biqy.a(getContext(), 10.0F)));
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
      localView = new View(getContext());
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, biqy.a(getContext(), 36.0F)));
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
    }
  }
  
  private void c()
  {
    urk.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bion instanceof biou)) {
      return;
    }
    biou localbiou = (biou)this.jdField_a_of_type_Bion;
    if (!localbiou.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bipb.notifyDataSetChanged();
      return;
    }
    if (localbiou.jdField_b_of_type_Boolean)
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
    urk.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bion);
    Object localObject = this.jdField_a_of_type_Bion;
    if (localObject == null) {}
    while (!(localObject instanceof biox)) {
      return;
    }
    biox localbiox = (biox)localObject;
    if ((localbiox.jdField_a_of_type_JavaUtilList != null) && (!localbiox.jdField_a_of_type_JavaUtilList.isEmpty())) {
      urk.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbiox.g)))
      {
        urk.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbiox.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbiox, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = aciy.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131495644, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300264));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300265));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131306298));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131300252));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131300245));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131303858));
    this.c = ((LinearLayout)super.findViewById(2131303863));
    this.d = ((LinearLayout)super.findViewById(2131303855));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299769));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bion == null) {
      urk.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bion.a())) {
            break;
          }
          localObject = (biou)this.jdField_a_of_type_Bion;
        } while ((!((biou)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((biou)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (badq.g(super.getContext())) {
          urp.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          urp.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bion.a()));
      localObject = (biox)this.jdField_a_of_type_Bion;
      ((bhlf)bhfm.a(14)).a(((biox)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!badq.a(getContext())) || (this.jdField_a_of_type_Biom == null) || (((biox)localObject).jdField_b_of_type_Boolean) || (!((biox)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    urk.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Biom.a(((biox)localObject).jdField_a_of_type_JavaLangString);
    urp.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bion parambion)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambion));
    }
    do
    {
      return;
      if (parambion == null) {
        break;
      }
      urk.b("FaceListPage", "onChange,FacePkgInfo:" + parambion.toString());
      if ((this.jdField_a_of_type_Bion == null) || (!this.jdField_a_of_type_Bion.a().equals(parambion.a()))) {
        b(parambion);
      }
      this.jdField_a_of_type_Bion = parambion;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bion.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bion.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bion.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bion.a()));
    d();
    return;
    urk.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bion = null;
    this.jdField_a_of_type_Bipb.a(null);
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
    bion localbion = this.jdField_a_of_type_Bion;
    int j = k;
    int m;
    int i;
    if (localbion != null)
    {
      m = localbion.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbion.b())
      {
        String str = localbion.a(i);
        urk.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Biom != null)
      {
        ((bhlf)bhfm.a(14)).a(this.jdField_a_of_type_Bion.jdField_a_of_type_JavaLangString, 4);
        if (((biox)this.jdField_a_of_type_Bion).jdField_b_of_type_Boolean) {
          break label108;
        }
        urk.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bion.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Biom.a(this.jdField_a_of_type_Bion.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638508));
      }
    }
    label108:
    while ((paramView != this.c) || (this.jdField_a_of_type_Biom == null))
    {
      return;
      this.jdField_a_of_type_Biom.b(this.jdField_a_of_type_Bion.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Biom.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */