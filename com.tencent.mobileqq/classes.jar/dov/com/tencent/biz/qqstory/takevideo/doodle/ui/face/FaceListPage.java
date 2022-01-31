package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import actn;
import ajyc;
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
import bbev;
import bjae;
import bjcd;
import bjfx;
import bkfh;
import bkfi;
import bkfj;
import bkfo;
import bkfp;
import bkfs;
import bkfw;
import bkgb;
import bkgh;
import bkgi;
import bkgl;
import bkht;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import veg;
import vel;

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
  private bjcd jdField_a_of_type_Bjcd;
  private bkfh jdField_a_of_type_Bkfh;
  private bkfi jdField_a_of_type_Bkfi;
  private bkfw jdField_a_of_type_Bkfw;
  private bkgb jdField_a_of_type_Bkgb;
  private bkgh jdField_a_of_type_Bkgh;
  private bkgi jdField_a_of_type_Bkgi;
  private bkgl jdField_a_of_type_Bkgl;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, bjcd parambjcd, bkfh parambkfh)
  {
    super(paramContext);
    this.jdField_a_of_type_Bkfh = parambkfh;
    this.jdField_a_of_type_Bjcd = parambjcd;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    veg.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bkfi instanceof bkfj)) {
      return;
    }
    if (!((bkfj)this.jdField_a_of_type_Bkfi).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bkfw.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bkfi parambkfi)
  {
    if ((parambkfi instanceof bkfs))
    {
      if (this.jdField_a_of_type_Bkgl == null) {
        this.jdField_a_of_type_Bkgl = new bkgl(super.getContext(), this);
      }
      this.jdField_a_of_type_Bkfw = this.jdField_a_of_type_Bkgl;
      if (!(parambkfi instanceof bkfo)) {
        break label227;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkfw != null)
      {
        this.jdField_a_of_type_Bkfw.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bkfw.a(this.jdField_a_of_type_Bjcd);
        this.jdField_a_of_type_Bkfw.a(parambkfi);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bkfw);
      }
      return;
      if ((parambkfi instanceof bkfp))
      {
        if (this.jdField_a_of_type_Bkgi == null) {
          this.jdField_a_of_type_Bkgi = new bkgi(super.getContext(), this);
        }
        this.jdField_a_of_type_Bkfw = this.jdField_a_of_type_Bkgi;
        break;
      }
      if ((parambkfi instanceof bkfj))
      {
        if (this.jdField_a_of_type_Bkgb == null) {
          this.jdField_a_of_type_Bkgb = new bkgb(super.getContext(), this);
        }
        this.jdField_a_of_type_Bkfw = this.jdField_a_of_type_Bkgb;
        break;
      }
      if ((parambkfi instanceof bkfo))
      {
        if (this.jdField_a_of_type_Bkgh == null) {
          this.jdField_a_of_type_Bkgh = new bkgh(super.getContext(), this);
        }
        this.jdField_a_of_type_Bkfw = this.jdField_a_of_type_Bkgh;
        break;
      }
      veg.e("FaceListPage", "FacePackage is illegal.");
      break;
      label227:
      View localView = new View(getContext());
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, bkht.a(getContext(), 10.0F)));
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
      localView = new View(getContext());
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, bkht.a(getContext(), 36.0F)));
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
    }
  }
  
  private void c()
  {
    veg.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bkfi instanceof bkfp)) {
      return;
    }
    bkfp localbkfp = (bkfp)this.jdField_a_of_type_Bkfi;
    if (!localbkfp.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bkfw.notifyDataSetChanged();
      return;
    }
    if (localbkfp.jdField_b_of_type_Boolean)
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
    veg.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bkfi);
    Object localObject = this.jdField_a_of_type_Bkfi;
    if (localObject == null) {}
    while (!(localObject instanceof bkfs)) {
      return;
    }
    bkfs localbkfs = (bkfs)localObject;
    if ((localbkfs.jdField_a_of_type_JavaUtilList != null) && (!localbkfs.jdField_a_of_type_JavaUtilList.isEmpty())) {
      veg.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbkfs.g)))
      {
        veg.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbkfs.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbkfs, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = actn.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561235, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365864));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131371995));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365850));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365843));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369533));
    this.c = ((LinearLayout)super.findViewById(2131369538));
    this.d = ((LinearLayout)super.findViewById(2131369530));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365336));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkfi == null) {
      veg.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bkfi.a())) {
            break;
          }
          localObject = (bkfp)this.jdField_a_of_type_Bkfi;
        } while ((!((bkfp)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bkfp)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (bbev.g(super.getContext())) {
          vel.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          vel.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bkfi.a()));
      localObject = (bkfs)this.jdField_a_of_type_Bkfi;
      ((bjfx)bjae.a(14)).a(((bkfs)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!bbev.a(getContext())) || (this.jdField_a_of_type_Bkfh == null) || (((bkfs)localObject).jdField_b_of_type_Boolean) || (!((bkfs)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    veg.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bkfh.a(((bkfs)localObject).jdField_a_of_type_JavaLangString);
    vel.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bkfi parambkfi)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambkfi));
    }
    do
    {
      return;
      if (parambkfi == null) {
        break;
      }
      veg.b("FaceListPage", "onChange,FacePkgInfo:" + parambkfi.toString());
      if ((this.jdField_a_of_type_Bkfi == null) || (!this.jdField_a_of_type_Bkfi.a().equals(parambkfi.a()))) {
        b(parambkfi);
      }
      this.jdField_a_of_type_Bkfi = parambkfi;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bkfi.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bkfi.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bkfi.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bkfi.a()));
    d();
    return;
    veg.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bkfi = null;
    this.jdField_a_of_type_Bkfw.a(null);
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
    bkfi localbkfi = this.jdField_a_of_type_Bkfi;
    int j = k;
    int m;
    int i;
    if (localbkfi != null)
    {
      m = localbkfi.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbkfi.b())
      {
        String str = localbkfi.a(i);
        veg.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bkfh != null)
      {
        ((bjfx)bjae.a(14)).a(this.jdField_a_of_type_Bkfi.jdField_a_of_type_JavaLangString, 4);
        if (((bkfs)this.jdField_a_of_type_Bkfi).jdField_b_of_type_Boolean) {
          break label108;
        }
        veg.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bkfi.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bkfh.a(this.jdField_a_of_type_Bkfi.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131704293));
      }
    }
    label108:
    while ((paramView != this.c) || (this.jdField_a_of_type_Bkfh == null))
    {
      return;
      this.jdField_a_of_type_Bkfh.b(this.jdField_a_of_type_Bkfi.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Bkfh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */