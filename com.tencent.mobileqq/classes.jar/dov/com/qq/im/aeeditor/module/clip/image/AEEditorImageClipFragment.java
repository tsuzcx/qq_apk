package dov.com.qq.im.aeeditor.module.clip.image;

import alud;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bdgm;
import bdjz;
import bdoo;
import bliu;
import bljn;
import bljy;
import bllr;
import blls;
import bllt;
import bllu;
import bllv;
import bllw;
import bllx;
import blly;
import bllz;
import blpy;
import blqb;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorClipPageTopBar;
import dov.com.qq.im.aeeditor.view.EditorClipView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import xsm;

public class AEEditorImageClipFragment
  extends AEEditorBaseFragment
  implements View.OnClickListener
{
  private static final double[] jdField_a_of_type_ArrayOfDouble = { 1.0D, 0.75D, 1.333333333333333D };
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1080, 1080, 1920, 2560 };
  private static final String jdField_b_of_type_JavaLangString = AEEditorImageClipFragment.class.getSimpleName();
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseArray<Bitmap> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bllz jdField_a_of_type_Bllz;
  private AEEditorClipPageTopBar jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar;
  private EditorClipView jdField_a_of_type_DovComQqImAeeditorViewEditorClipView;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[9];
  private int jdField_b_of_type_Int;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = true;
  private int[] jdField_b_of_type_ArrayOfInt = new int[9];
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[9];
  private int jdField_d_of_type_Int = bdoo.a();
  private boolean jdField_d_of_type_Boolean;
  private int[] jdField_d_of_type_ArrayOfInt = new int[9];
  private int[] e = new int[9];
  
  private int a(int paramInt)
  {
    int i = paramInt + 1;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_a_of_type_ArrayOfBoolean[i] != 0) {
        return i;
      }
      i += 1;
    }
    paramInt -= 1;
    for (;;)
    {
      if (paramInt < 0) {
        break label59;
      }
      i = paramInt;
      if (this.jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
        break;
      }
      paramInt -= 1;
    }
    label59:
    return 0;
  }
  
  private Bitmap a(String paramString, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = paramInt;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, EditorClipView paramEditorClipView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    localValueAnimator.addUpdateListener(new bllu(this, paramEditorClipView));
    localValueAnimator.setDuration(paramInt2);
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    localValueAnimator.addUpdateListener(new bllv(this, paramEditorClipView));
    localValueAnimator.setDuration(paramInt2);
    localValueAnimator.start();
    localValueAnimator.addListener(new bllw(this, paramEditorClipView));
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131364936));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375208));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375209));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375210));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364323));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377826));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar = ((AEEditorClipPageTopBar)paramView.findViewById(2131364324));
  }
  
  private void a(EditorPicInfo paramEditorPicInfo)
  {
    if (paramEditorPicInfo == null) {}
    double d3;
    double d4;
    do
    {
      return;
      double d1 = paramEditorPicInfo.x;
      double d2 = paramEditorPicInfo.w;
      d3 = paramEditorPicInfo.y;
      d4 = paramEditorPicInfo.h;
      paramEditorPicInfo.x = Math.max(paramEditorPicInfo.x, 0.0D);
      paramEditorPicInfo.x = Math.min(paramEditorPicInfo.x, 1.0D);
      if (paramEditorPicInfo.x < 0.001D) {
        paramEditorPicInfo.x = 0.0D;
      }
      paramEditorPicInfo.y = Math.max(paramEditorPicInfo.y, 0.0D);
      paramEditorPicInfo.y = Math.min(paramEditorPicInfo.y, 1.0D);
      if (paramEditorPicInfo.y < 0.001D) {
        paramEditorPicInfo.y = 0.0D;
      }
      paramEditorPicInfo.w = Math.min(paramEditorPicInfo.w, 1.0D - paramEditorPicInfo.x);
      paramEditorPicInfo.h = Math.min(paramEditorPicInfo.h, 1.0D - paramEditorPicInfo.y);
      if (Math.abs(d1 + d2 - 1.0D) < 0.001D) {
        paramEditorPicInfo.w = (1.0D - paramEditorPicInfo.x);
      }
    } while (Math.abs(d3 + d4 - 1.0D) >= 0.001D);
    paramEditorPicInfo.h = (1.0D - paramEditorPicInfo.y);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (this.jdField_a_of_type_ArrayOfBoolean[i] == 0) {
          break label40;
        }
        bool1 = bool2;
        if (i == paramInt) {
          bool1 = true;
        }
      }
      return bool1;
      label40:
      i += 1;
    }
  }
  
  private int b(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (i <= paramInt)
    {
      int k = j;
      if (this.jdField_a_of_type_ArrayOfBoolean[i] != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private void b(int paramInt)
  {
    int j = 0;
    if (!this.jdField_a_of_type_Boolean) {}
    while (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    int i;
    if (localObject == null)
    {
      i = Math.max(OfflineConfig.getPhonePerfLevel() - 1, 0);
      i = Math.max(this.jdField_b_of_type_ArrayOfInt[paramInt] / jdField_a_of_type_ArrayOfInt[i], this.jdField_c_of_type_ArrayOfInt[paramInt] / jdField_a_of_type_ArrayOfInt[i]);
      localObject = a((String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), i + 1);
      Bitmap localBitmap = xsm.a((Bitmap)localObject, this.e[paramInt]);
      if ((localObject != localBitmap) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
      if (localBitmap == null)
      {
        QQToast.a(getActivity(), "图片不存在或已经被删除", 1).a();
        return;
      }
      localObject = LayoutInflater.from(getActivity()).inflate(2131558526, this.jdField_a_of_type_AndroidWidgetFrameLayout, false);
      ((EditorClipView)((View)localObject).findViewById(2131364939)).setImageBitmap(localBitmap);
      ((EditorClipView)((View)localObject).findViewById(2131364939)).setClipWindowWidthChangeListener(new blls(this));
      ((EditorClipView)((View)localObject).findViewById(2131364939)).setClipViewOperateListener(new bllt(this));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localBitmap);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView = ((EditorClipView)((View)localObject).findViewById(2131364939));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
      a((int)(this.jdField_d_of_type_Int / jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[0]] - this.jdField_d_of_type_Int / jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[paramInt]]) / 2, 10, this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView);
      this.jdField_d_of_type_ArrayOfInt[paramInt] = this.jdField_d_of_type_ArrayOfInt[0];
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (a(paramInt))
      {
        i = 0;
        ((ImageView)localObject).setVisibility(i);
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!a(paramInt)) {
          break label433;
        }
        i = 0;
        label386:
        ((ImageView)localObject).setVisibility(i);
        localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        if (!a(paramInt)) {
          break label439;
        }
      }
      label433:
      label439:
      for (i = j;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar.setIndex(b(paramInt));
        return;
        i = 8;
        break;
        i = 8;
        break label386;
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_ArrayOfBoolean[i] != 0) {
        k = j + 1;
      }
      i += 1;
    }
    if (j == 1) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("PhotoConst.SELECTED_PATHS"))) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS"));
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_d_of_type_ArrayOfInt[0] == paramInt) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    d(paramInt);
    int i = (int)(this.jdField_d_of_type_Int / jdField_a_of_type_ArrayOfDouble[paramInt] - this.jdField_d_of_type_Int / jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[0]]) / 2;
    this.jdField_d_of_type_ArrayOfInt[0] = paramInt;
    a(i, 300, this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView);
  }
  
  private boolean c()
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 500L) {
      return true;
    }
    this.jdField_a_of_type_Long = l;
    return false;
  }
  
  private void d()
  {
    int i = bdoo.a();
    int j = bdoo.b();
    int k = blpy.a(getActivity(), 250.0F);
    i = Math.max((int)((i - (j - k) * 3 / 4.0F) / 2.0F), 0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(i, 0, i, 0);
  }
  
  private void d(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramInt == 0)
    {
      i = 2130837676;
      localImageView.setImageResource(i);
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramInt != 1) {
        break label64;
      }
      i = 2130837678;
      label32:
      localImageView.setImageResource(i);
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramInt != 2) {
        break label71;
      }
    }
    label64:
    label71:
    for (paramInt = 2130837680;; paramInt = 2130837681)
    {
      localImageView.setImageResource(paramInt);
      return;
      i = 2130837677;
      break;
      i = 2130837679;
      break label32;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar.setClipPageTopBarClickListener(new bllr(this));
  }
  
  private void f()
  {
    int i;
    if ((this.jdField_c_of_type_ArrayOfInt[0] == 0) || (this.jdField_b_of_type_ArrayOfInt[0] == 0)) {
      i = 0;
    }
    for (;;)
    {
      blqb.a(jdField_a_of_type_ArrayOfDouble[i]);
      Arrays.fill(this.jdField_d_of_type_ArrayOfInt, i);
      Arrays.fill(this.jdField_a_of_type_ArrayOfBoolean, true);
      d(i);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Int = -1;
      b(0);
      return;
      if (this.jdField_c_of_type_ArrayOfInt[0] * 1.0F / this.jdField_b_of_type_ArrayOfInt[0] >= 1.166666746139526D) {
        i = 1;
      } else if (this.jdField_c_of_type_ArrayOfInt[0] * 1.0F / this.jdField_b_of_type_ArrayOfInt[0] <= 0.875D) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  private void g()
  {
    bljn.d(jdField_b_of_type_JavaLangString, "handleNextStep");
    ArrayList localArrayList = new ArrayList();
    bliu.a().a(this.jdField_a_of_type_JavaUtilArrayList.size());
    int j = 0;
    int i = 0;
    Object localObject1;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_a_of_type_ArrayOfBoolean[i] == 0) {}
      while (!a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)))
      {
        i += 1;
        break;
      }
      if (this.jdField_b_of_type_AndroidUtilSparseArray.get(i) != null)
      {
        localObject1 = (EditorClipView)((View)this.jdField_b_of_type_AndroidUtilSparseArray.get(i)).findViewById(2131364939);
        if (this.jdField_d_of_type_ArrayOfInt[0] == this.jdField_d_of_type_ArrayOfInt[i]) {
          localObject1 = ((EditorClipView)localObject1).a();
        }
      }
      for (;;)
      {
        ((EditorPicInfo)localObject1).picPath = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        ((EditorPicInfo)localObject1).originPicWidth = this.jdField_b_of_type_ArrayOfInt[i];
        ((EditorPicInfo)localObject1).originPicHeight = this.jdField_c_of_type_ArrayOfInt[i];
        a((EditorPicInfo)localObject1);
        localArrayList.add(localObject1);
        bljn.d(jdField_b_of_type_JavaLangString, "cropInfo::" + ((EditorPicInfo)localObject1).x + "," + ((EditorPicInfo)localObject1).y + "," + ((EditorPicInfo)localObject1).w + "," + ((EditorPicInfo)localObject1).h + "," + ((EditorPicInfo)localObject1).originPicWidth + "," + ((EditorPicInfo)localObject1).originPicHeight);
        j = 1;
        break;
        RectF localRectF1;
        RectF localRectF2;
        Object localObject2;
        if (jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[i]] < jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[0]])
        {
          localRectF1 = new RectF(((EditorClipView)localObject1).a());
          localRectF2 = new RectF(((EditorClipView)localObject1).b());
          localObject2 = new Matrix();
          ((Matrix)localObject2).setScale(1.0F, (float)(jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[i]] / jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[0]]), localRectF2.centerX(), localRectF2.centerY());
          ((Matrix)localObject2).mapRect(localRectF2);
          localObject1 = ((EditorClipView)localObject1).a(localRectF1, localRectF2);
        }
        else
        {
          localRectF1 = new RectF(((EditorClipView)localObject1).a());
          localRectF2 = new RectF(((EditorClipView)localObject1).b());
          localObject2 = new RectF(localRectF2);
          Matrix localMatrix = new Matrix();
          localMatrix.setScale(1.0F, (float)(jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[i]] / jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[0]]), localRectF2.centerX(), localRectF2.centerY());
          localMatrix.mapRect(localRectF2);
          if (localRectF1.height() > localRectF2.height())
          {
            f = 0.0F;
            if (localRectF2.top < localRectF1.top) {
              f = localRectF1.top - localRectF2.top;
            }
            for (;;)
            {
              localMatrix.reset();
              localMatrix.setTranslate(0.0F, f);
              localMatrix.mapRect(localRectF2);
              localObject1 = ((EditorClipView)localObject1).a(localRectF1, localRectF2);
              break;
              if (localRectF2.bottom > localRectF1.bottom) {
                f = localRectF1.bottom - localRectF2.bottom;
              }
            }
          }
          float f = 1.0F / ((localRectF2.height() - localRectF1.height()) / localRectF1.height() + 1.0F);
          localMatrix.reset();
          localMatrix.setScale(f, 1.0F, ((RectF)localObject2).centerX(), ((RectF)localObject2).centerY());
          localMatrix.mapRect((RectF)localObject2);
          localObject1 = ((EditorClipView)localObject1).a(localRectF1, (RectF)localObject2);
          ((EditorPicInfo)localObject1).y = 0.0D;
          ((EditorPicInfo)localObject1).h = 1.0D;
          continue;
          localObject1 = new EditorPicInfo();
          j = this.jdField_b_of_type_ArrayOfInt[i];
          int k = this.jdField_c_of_type_ArrayOfInt[i];
          double d1 = jdField_a_of_type_ArrayOfDouble[this.jdField_d_of_type_ArrayOfInt[0]];
          if (1.0F * j / k < d1)
          {
            ((EditorPicInfo)localObject1).x = 0.0D;
            ((EditorPicInfo)localObject1).y = ((k - j / d1) / 2.0D / k);
            ((EditorPicInfo)localObject1).w = 1.0D;
            ((EditorPicInfo)localObject1).h = (j / d1 / k);
          }
          else
          {
            ((EditorPicInfo)localObject1).x = ((j - k * d1) / 2.0D / j);
            ((EditorPicInfo)localObject1).y = 0.0D;
            ((EditorPicInfo)localObject1).w = (d1 * k / j);
            ((EditorPicInfo)localObject1).h = 1.0D;
          }
        }
      }
    }
    bljn.d(jdField_b_of_type_JavaLangString, "cropInfo  end");
    if (j != 0)
    {
      localObject1 = new Bundle(getArguments());
      ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList);
      a().a(a(), (Bundle)localObject1);
      return;
    }
    QQToast.a(getActivity(), "图片不存在或已经被删除", 1).a();
  }
  
  private void h()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      Size localSize = BitmapUtil.getImageSize((String)localObject);
      this.jdField_b_of_type_ArrayOfInt[i] = localSize.getWidth();
      this.jdField_c_of_type_ArrayOfInt[i] = localSize.getHeight();
      this.e[i] = BitmapUtil.getImageRotation((String)localObject);
      i += 1;
    }
    Object localObject = new LinearLayoutManager(getActivity());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_Bllz = new bllz(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bllz);
  }
  
  public String a()
  {
    return "AEEditorImageClip";
  }
  
  public boolean a()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return false;
    }
    Object localObject = getActivity();
    localObject = bdgm.a((Context)localObject, 230).setTitle(alud.a(2131689805)).setMessage(((Context)localObject).getString(2131689806)).setPositiveButton(((Context)localObject).getString(2131689805), new blly(this)).setNegativeButton(((Context)localObject).getString(2131689792), new bllx(this));
    if (localObject != null) {}
    try
    {
      if (!((bdjz)localObject).isShowing()) {
        ((bdjz)localObject).show();
      }
      label92:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label92;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131375208)
    {
      c(0);
      this.jdField_d_of_type_Boolean = true;
    }
    do
    {
      return;
      if (i == 2131375209)
      {
        c(1);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      if (i == 2131375210)
      {
        c(2);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
    } while (i != 2131364323);
    g();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bljn.b(jdField_b_of_type_JavaLangString, "onCreate");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onCreateView");
    a(2131165220);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558529, paramViewGroup, false);
    }
    if ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bljn.b(jdField_b_of_type_JavaLangString, "onDestroy");
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        i += 1;
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!this.jdField_c_of_type_Boolean)
    {
      c();
      a(paramView);
      d();
      h();
      f();
      e();
      this.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment
 * JD-Core Version:    0.7.0.1
 */