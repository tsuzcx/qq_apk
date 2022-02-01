package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import amtj;
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
import bmql;
import bmsl;
import bmuq;
import bnld;
import bnle;
import bnlf;
import bnlk;
import bnln;
import bnlr;
import bnlw;
import bnmc;
import bnmf;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import xvv;
import xwa;

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
  private bmsl jdField_a_of_type_Bmsl;
  private bnld jdField_a_of_type_Bnld;
  private bnle jdField_a_of_type_Bnle;
  private bnlr jdField_a_of_type_Bnlr;
  private bnlw jdField_a_of_type_Bnlw;
  private bnmc jdField_a_of_type_Bnmc;
  private bnmf jdField_a_of_type_Bnmf;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, bmsl parambmsl, bnld parambnld)
  {
    super(paramContext);
    this.jdField_a_of_type_Bnld = parambnld;
    this.jdField_a_of_type_Bmsl = parambmsl;
    e();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    xvv.b("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Bnle instanceof bnlf)) {
      return;
    }
    if (!((bnlf)this.jdField_a_of_type_Bnle).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bnlr.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(bnle parambnle)
  {
    if ((parambnle instanceof bnln))
    {
      if (this.jdField_a_of_type_Bnmf == null) {
        this.jdField_a_of_type_Bnmf = new bnmf(super.getContext(), this);
      }
      this.jdField_a_of_type_Bnlr = this.jdField_a_of_type_Bnmf;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bnlr != null)
      {
        this.jdField_a_of_type_Bnlr.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bnlr.a(this.jdField_a_of_type_Bmsl);
        this.jdField_a_of_type_Bnlr.a(parambnle);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bnlr);
      }
      return;
      if ((parambnle instanceof bnlk))
      {
        if (this.jdField_a_of_type_Bnmc == null) {
          this.jdField_a_of_type_Bnmc = new bnmc(super.getContext(), this);
        }
        this.jdField_a_of_type_Bnlr = this.jdField_a_of_type_Bnmc;
      }
      else if ((parambnle instanceof bnlf))
      {
        if (this.jdField_a_of_type_Bnlw == null) {
          this.jdField_a_of_type_Bnlw = new bnlw(super.getContext(), this);
        }
        this.jdField_a_of_type_Bnlr = this.jdField_a_of_type_Bnlw;
      }
      else
      {
        xvv.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    xvv.b("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Bnle instanceof bnlk)) {
      return;
    }
    bnlk localbnlk = (bnlk)this.jdField_a_of_type_Bnle;
    if (!localbnlk.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Bnlr.notifyDataSetChanged();
      return;
    }
    if (localbnlk.jdField_b_of_type_Boolean)
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
    xvv.b("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Bnle);
    Object localObject = this.jdField_a_of_type_Bnle;
    if (localObject == null) {}
    while (!(localObject instanceof bnln)) {
      return;
    }
    bnln localbnln = (bnln)localObject;
    if ((localbnln.jdField_a_of_type_JavaUtilList != null) && (!localbnln.jdField_a_of_type_JavaUtilList.isEmpty())) {
      xvv.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localbnln.g)))
      {
        xvv.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localbnln.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localbnln, (List)localObject, bool1));
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
    LayoutInflater.from(super.getContext()).inflate(2131561597, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366279));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373009));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366265));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366259));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370319));
    this.c = ((LinearLayout)super.findViewById(2131370324));
    this.d = ((LinearLayout)super.findViewById(2131370316));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365733));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bnle == null) {
      xvv.b("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Bnle.a())) {
            break;
          }
          localObject = (bnlk)this.jdField_a_of_type_Bnle;
        } while ((!((bnlk)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((bnlk)localObject).jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Boolean));
        if (NetworkUtil.isNetworkAvailable(super.getContext())) {
          xwa.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          return;
          xwa.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Bnle.a()));
      localObject = (bnln)this.jdField_a_of_type_Bnle;
      ((bmuq)bmql.a(14)).a(((bnln)localObject).jdField_a_of_type_JavaLangString, 4);
    } while ((!NetworkUtil.isWifiEnabled(getContext())) || (this.jdField_a_of_type_Bnld == null) || (((bnln)localObject).jdField_b_of_type_Boolean) || (!((bnln)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    xvv.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Bnld.a(((bnln)localObject).jdField_a_of_type_JavaLangString);
    xwa.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(bnle parambnle)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, parambnle));
    }
    do
    {
      return;
      if (parambnle == null) {
        break;
      }
      xvv.b("FaceListPage", "onChange,FacePkgInfo:" + parambnle.toString());
      if ((this.jdField_a_of_type_Bnle == null) || (!this.jdField_a_of_type_Bnle.a().equals(parambnle.a()))) {
        b(parambnle);
      }
      this.jdField_a_of_type_Bnle = parambnle;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Bnle.a()))
      {
        d();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Bnle.a()))
      {
        c();
        return;
      }
    } while (!"InformationFacePackage".equals(this.jdField_a_of_type_Bnle.a()));
    b();
    return;
    xvv.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Bnle = null;
    this.jdField_a_of_type_Bnlr.a(null);
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
    bnle localbnle = this.jdField_a_of_type_Bnle;
    int j = k;
    int m;
    int i;
    if (localbnle != null)
    {
      m = localbnle.a();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localbnle.b())
      {
        String str = localbnle.a(i);
        xvv.b("FaceListPage", "selectByName : " + paramString + str);
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
      if (this.jdField_a_of_type_Bnld != null)
      {
        ((bmuq)bmql.a(14)).a(this.jdField_a_of_type_Bnle.jdField_a_of_type_JavaLangString, 4);
        if (((bnln)this.jdField_a_of_type_Bnle).jdField_b_of_type_Boolean) {
          break label115;
        }
        xvv.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Bnle.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bnld.a(this.jdField_a_of_type_Bnle.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131703422));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      this.jdField_a_of_type_Bnld.b(this.jdField_a_of_type_Bnle.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Bnld != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Bnld.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */