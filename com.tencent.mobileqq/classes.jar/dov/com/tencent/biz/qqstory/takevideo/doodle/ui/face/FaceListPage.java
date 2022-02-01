package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import agej;
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
import anzj;
import bhnv;
import bplq;
import bpnq;
import bprk;
import bqov;
import bqow;
import bqox;
import bqpc;
import bqpd;
import bqpg;
import bqpk;
import bqpp;
import bqpv;
import bqpw;
import bqpz;
import bqrh;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import yuk;
import yup;

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
  private bpnq jdField_a_of_type_Bpnq;
  private bqov jdField_a_of_type_Bqov;
  private bqow jdField_a_of_type_Bqow;
  private bqpk jdField_a_of_type_Bqpk;
  private bqpp jdField_a_of_type_Bqpp;
  private bqpv jdField_a_of_type_Bqpv;
  private bqpw jdField_a_of_type_Bqpw;
  private bqpz jdField_a_of_type_Bqpz;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, bpnq parambpnq, bqov parambqov)
  {
    super(paramContext);
    this.jdField_a_of_type_Bqov = parambqov;
    this.jdField_a_of_type_Bpnq = parambpnq;
    f();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    yuk.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bqow instanceof bqox)) {
      return;
    }
    if (!((bqox)this.jdField_a_of_type_Bqow).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bqpk.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bqow parambqow)
  {
    if ((parambqow instanceof bqpg))
    {
      if (this.jdField_a_of_type_Bqpz == null) {
        this.jdField_a_of_type_Bqpz = new bqpz(super.getContext(), this);
      }
      this.jdField_a_of_type_Bqpk = this.jdField_a_of_type_Bqpz;
    }
    for (;;)
    {
      if (!(parambqow instanceof bqpc))
      {
        View localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bqrh.b(getContext(), 10.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(localView);
        localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, bqrh.b(getContext(), 36.0F)));
        localView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
      }
      if (this.jdField_a_of_type_Bqpk != null)
      {
        this.jdField_a_of_type_Bqpk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bqpk.a(this.jdField_a_of_type_Bpnq);
        this.jdField_a_of_type_Bqpk.a(parambqow);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bqpk);
      }
      return;
      if ((parambqow instanceof bqpd))
      {
        if (this.jdField_a_of_type_Bqpw == null) {
          this.jdField_a_of_type_Bqpw = new bqpw(super.getContext(), this);
        }
        this.jdField_a_of_type_Bqpk = this.jdField_a_of_type_Bqpw;
      }
      else if ((parambqow instanceof bqox))
      {
        if (this.jdField_a_of_type_Bqpp == null) {
          this.jdField_a_of_type_Bqpp = new bqpp(super.getContext(), this);
        }
        this.jdField_a_of_type_Bqpk = this.jdField_a_of_type_Bqpp;
      }
      else if ((parambqow instanceof bqpc))
      {
        if (this.jdField_a_of_type_Bqpv == null) {
          this.jdField_a_of_type_Bqpv = new bqpv(super.getContext(), this);
        }
        this.jdField_a_of_type_Bqpk = this.jdField_a_of_type_Bqpv;
      }
      else
      {
        yuk.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    yuk.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bqow instanceof bqpd)) {
      return;
    }
    bqpd localbqpd = (bqpd)this.jdField_a_of_type_Bqow;
    if (!localbqpd.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bqpk.notifyDataSetChanged();
      return;
    }
    if (localbqpd.jdField_b_of_type_Boolean)
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
    yuk.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bqow);
    Object localObject = this.jdField_a_of_type_Bqow;
    if (localObject == null) {}
    while (!(localObject instanceof bqpg)) {
      return;
    }
    bqpg localbqpg = (bqpg)localObject;
    if ((localbqpg.jdField_a_of_type_JavaUtilList != null) && (!localbqpg.jdField_a_of_type_JavaUtilList.isEmpty())) {
      yuk.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbqpg.g)))
      {
        yuk.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbqpg.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbqpg, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Int = agej.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561719, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366251));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366252));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373039));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366238));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366232));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370351));
    this.c = ((LinearLayout)super.findViewById(2131370356));
    this.d = ((LinearLayout)super.findViewById(2131370348));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365700));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bqow == null) {
      yuk.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bqow.a())) {
            break;
          }
          localObject = (bqpd)this.jdField_a_of_type_Bqow;
        } while ((!((bqpd)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bqpd)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (bhnv.g(super.getContext())) {
          yup.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          yup.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bqow.a()));
      localObject = (bqpg)this.jdField_a_of_type_Bqow;
      ((bprk)bplq.a(14)).a(((bqpg)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!bhnv.a(getContext())) || (this.jdField_a_of_type_Bqov == null) || (((bqpg)localObject).jdField_b_of_type_Boolean) || (!((bqpg)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    yuk.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bqov.a(((bqpg)localObject).jdField_a_of_type_JavaLangString);
    yup.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bqow parambqow)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambqow));
    }
    do
    {
      return;
      if (parambqow == null) {
        break;
      }
      yuk.b("FaceListPage", "onChange,FacePkgInfo:" + parambqow.toString());
      if ((this.jdField_a_of_type_Bqow == null) || (!this.jdField_a_of_type_Bqow.a().equals(parambqow.a()))) {
        b(parambqow);
      }
      this.jdField_a_of_type_Bqow = parambqow;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bqow.a()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bqow.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Bqow.a()))
      {
        b();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Bqow.a()));
    d();
    return;
    yuk.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bqow = null;
    this.jdField_a_of_type_Bqpk.a(null);
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
    bqow localbqow = this.jdField_a_of_type_Bqow;
    int j = k;
    int m;
    int i;
    if (localbqow != null)
    {
      m = localbqow.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbqow.b())
      {
        String str = localbqow.a(i);
        yuk.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bqov != null)
      {
        ((bprk)bplq.a(14)).a(this.jdField_a_of_type_Bqow.jdField_a_of_type_JavaLangString, 4);
        if (((bqpg)this.jdField_a_of_type_Bqow).jdField_b_of_type_Boolean) {
          break label115;
        }
        yuk.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bqow.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bqov.a(this.jdField_a_of_type_Bqow.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131703192));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      this.jdField_a_of_type_Bqov.b(this.jdField_a_of_type_Bqow.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Bqov != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Bqov.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */