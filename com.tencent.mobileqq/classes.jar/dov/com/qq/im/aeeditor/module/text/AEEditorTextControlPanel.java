package dov.com.qq.im.aeeditor.module.text;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import bpam;
import bpan;
import bpbq;
import bphr;
import bpjp;
import bpjr;
import bpjs;
import bpju;
import bpjv;
import bpkf;
import bpkh;
import bpki;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.imcore.constants.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.bean.TextEditorData;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEEditorTextControlPanel
  extends FrameLayout
  implements View.OnClickListener, bpjp, bpkh, bpki
{
  private static final String jdField_a_of_type_JavaLangString = bpbq.jdField_b_of_type_JavaLangString + File.separator + "text_sticker_thumb" + File.separator;
  private int jdField_a_of_type_Int = -1;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bpjv jdField_a_of_type_Bpjv;
  private bpkf jdField_a_of_type_Bpkf;
  private AEEditorColorSelectorView jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView;
  private List<AEEditorTextBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = bpan.a();
  private boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[9];
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean[] jdField_b_of_type_ArrayOfBoolean = new boolean[9];
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  
  public AEEditorTextControlPanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorTextControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorTextControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    this.jdField_d_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296277);
  }
  
  private void a(@NonNull Context paramContext)
  {
    View localView = View.inflate(paramContext, 2131558561, this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView = ((AEEditorColorSelectorView)localView.findViewById(2131364735));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setColorSelectedListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131378023));
    paramContext = new GridLayoutManager(paramContext, 5, 1, false);
    paramContext.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369025));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void a(TextView paramTextView)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramTextView, "translationY", new float[] { 0.0F, 40.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.addListener(new bpju(this, paramTextView));
    paramTextView = new AnimatorSet();
    paramTextView.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    paramTextView.setInterpolator(new DecelerateInterpolator());
    paramTextView.setDuration(350L);
    paramTextView.start();
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] != 0) && (this.jdField_b_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] != 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Int != paramInt))
    {
      this.jdField_c_of_type_Int = paramInt;
      h();
      g();
    }
  }
  
  public static void f()
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorTextControlPanel.8());
  }
  
  private void g()
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorTextControlPanel.1(this));
  }
  
  private void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      if (localAEEditorTextBean.type == 1) {
        localAEEditorTextBean.thumbPath = (jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + "_" + localAEEditorTextBean.id + ".png");
      }
    }
    ThreadManager.getUIHandler().post(new AEEditorTextControlPanel.2(this));
  }
  
  private void i()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_d_of_type_Boolean)
        {
          bpam.a("AEEditorTextControlPanel", "[animationUp], mOnAnimating=" + this.jdField_d_of_type_Boolean);
          return;
        }
        this.jdField_d_of_type_Boolean = true;
        int i;
        if (getMeasuredHeight() != 0)
        {
          i = getMeasuredHeight();
          ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "translationY", new float[] { i, 0.0F });
          ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
          localAnimatorSet.setDuration(200L);
          localAnimatorSet.addListener(new bpjr(this));
          localAnimatorSet.start();
        }
        else
        {
          i = this.jdField_d_of_type_Int;
        }
      }
      finally {}
    }
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        if (this.e)
        {
          bpam.a("AEEditorTextControlPanel", "[animationDown], mOnAnimating=" + this.e);
          return;
        }
        this.e = true;
        int i;
        if (getMeasuredHeight() != 0)
        {
          i = getMeasuredHeight();
          ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, i });
          ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
          localAnimatorSet.setDuration(200L);
          localAnimatorSet.addListener(new bpjs(this));
          localAnimatorSet.start();
        }
        else
        {
          i = this.jdField_d_of_type_Int;
        }
      }
      finally {}
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(null);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Bpkf != null) {
      this.jdField_a_of_type_Bpkf.d(-1);
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.d();
  }
  
  private void l()
  {
    AEEditorTextControlPanel.6 local6 = new AEEditorTextControlPanel.6(this);
    ThreadManager.getUIHandler().post(local6);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(AEEditorTextBean paramAEEditorTextBean)
  {
    int i = 0;
    if (paramAEEditorTextBean.aiColorIndex >= 0) {
      i = (paramAEEditorTextBean.aiColorIndex + 3) % 4;
    }
    for (;;)
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a().get(i);
      if (localInteger == null) {
        break;
      }
      return localInteger.intValue();
      bpam.d("AEEditorTextControlPanel", "[getTextLightnessByAEEditorTextBean] position is default");
    }
    bpam.d("AEEditorTextControlPanel", "[getColorByAEEditorTextBean] error !!!!");
    return paramAEEditorTextBean.backgroundColor;
  }
  
  public int a(@NonNull String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      if (paramString.equals(localAEEditorTextBean.id)) {
        return localAEEditorTextBean.type;
      }
    }
    bpam.d("AEEditorTextControlPanel", "[getTypeByID] ERROR !!!!");
    return 0;
  }
  
  @Nullable
  public Integer a(int paramInt, @Nullable AEEditorTextBean paramAEEditorTextBean)
  {
    Float localFloat = (Float)this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.c().get(paramInt);
    bpam.a("AEEditorTextControlPanel", "[getTextColorByAEEditorTextBean] lightness:" + localFloat);
    if (localFloat != null)
    {
      if (localFloat.floatValue() <= 0.8F) {
        return Integer.valueOf(-1);
      }
      return Integer.valueOf(AEEditorColorSelectorView.jdField_b_of_type_Int);
    }
    if (paramAEEditorTextBean != null)
    {
      if (paramAEEditorTextBean.backgroundColor != -1) {
        return Integer.valueOf(-1);
      }
      return Integer.valueOf(AEEditorColorSelectorView.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = "none";
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a().contains(Integer.valueOf(paramInt))) {
      str = "ai_color";
    }
    while (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.b().contains(Integer.valueOf(paramInt))) {
      return str;
    }
    return "common_color";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      if (a())
      {
        setIsNeedCreateThumbImage(2);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.b();
      }
    }
    else {
      return;
    }
    setIsNeedCreateThumbImage(3);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(Integer.valueOf(paramInt));
      return;
    }
    bpam.d("AEEditorTextControlPanel", "[selectColor] mAEEditorColorSelectorView null");
  }
  
  public void a(int paramInt, @NonNull AEEditorTextBean paramAEEditorTextBean)
  {
    switch (paramAEEditorTextBean.type)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Bpkf != null) {
      this.jdField_a_of_type_Bpkf.d(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpjv.a(paramInt, paramAEEditorTextBean);
      return;
      if (AppSetting.isPublicVersion) {
        throw new RuntimeException("mTextStickerAdapter null");
      }
      bpam.d("AEEditorTextControlPanel", "[onTextStickerClick] mTextStickerAdapter null");
    }
  }
  
  public void a(int paramInt, List<ImageMainColorData> paramList, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(paramList, paramBoolean);
      }
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
      d(paramInt);
    }
  }
  
  public void a(@Nullable TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null)
    {
      if (this.jdField_a_of_type_Bpkf != null) {
        this.jdField_a_of_type_Bpkf.a(null);
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(null);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bpkf != null) {
        this.jdField_a_of_type_Bpkf.a(paramTextEditorData.getItemID());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      AEEditorTextBean localAEEditorTextBean;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localAEEditorTextBean = (AEEditorTextBean)((Iterator)localObject).next();
      } while (!localAEEditorTextBean.id.equals(paramTextEditorData.getItemID()));
      for (localObject = AEEditorTextBean.updateTextBeanByStickerConfig(localAEEditorTextBean, bphr.a().a(bphr.a().d(paramTextEditorData.getItemID()))); localObject != null; localObject = null)
      {
        if (((AEEditorTextBean)localObject).type == 0)
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(Integer.valueOf(paramTextEditorData.getTextColor()));
          return;
        }
        if (paramTextEditorData.getColorList().get("bgcolor") != null) {}
        for (int i = ((Integer)paramTextEditorData.getColorList().get("bgcolor")).intValue();; i = ((AEEditorTextBean)localObject).backgroundColor)
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(Integer.valueOf(i));
          return;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_Bpjv.a(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.getVisibility() == 0) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setStickerId(paramString);
      paramString = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a();
      if ((paramString == null) || (paramString.getVisibility() == 8) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 3))
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.getVisibility() != 0) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setVisibility(0);
        }
        paramString.setVisibility(4);
        return;
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.getVisibility() == 0);
    l();
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a().iterator();
    boolean bool = true;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((bool) && (localInteger != null)) {}
      for (bool = true; !bool; bool = false) {
        return bool;
      }
    }
    return bool;
  }
  
  public int b(@NonNull AEEditorTextBean paramAEEditorTextBean)
  {
    int i = 0;
    if (paramAEEditorTextBean.aiColorIndex >= 0) {
      i = (paramAEEditorTextBean.aiColorIndex + 3) % 4;
    }
    Integer localInteger;
    for (;;)
    {
      localInteger = a(i, paramAEEditorTextBean);
      if (localInteger != null) {
        break;
      }
      return paramAEEditorTextBean.textColor;
      bpam.d("AEEditorTextControlPanel", "[getTextLightnessByAEEditorTextBean] position is default");
    }
    return localInteger.intValue();
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if ((bphr.a().c()) && (this.jdField_b_of_type_Boolean)) {
        setIsNeedCreateThumbImage(1);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        Iterator localIterator = ((AEEditorPagStickerGroup)bphr.a().a().get(0)).stickerInfoList.iterator();
        while (localIterator.hasNext())
        {
          AEEditorTextBean localAEEditorTextBean = AEEditorTextBean.createTextBeanByStickerInfo((AEEditorPagStickerInfo)localIterator.next());
          if (localAEEditorTextBean != null) {
            this.jdField_a_of_type_JavaUtilList.add(localAEEditorTextBean);
          }
        }
        setIsNeedCreateThumbImage(0);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label157;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpkf = new bpkf(this.jdField_a_of_type_JavaUtilList, this, this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bpkf);
      this.jdField_c_of_type_Boolean = true;
      return;
      label157:
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_ArrayOfBoolean[paramInt] = true;
    d(paramInt);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setVisibility(8);
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && (paramInt >= 0)) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEEditorTextControlPanel.5(this, paramInt));
    }
  }
  
  public void d()
  {
    if (getVisibility() == 0)
    {
      j();
      return;
    }
    bpam.a("AEEditorTextControlPanel", "[hide] not need hide");
  }
  
  public void e()
  {
    if (getVisibility() != 0)
    {
      i();
      return;
    }
    bpam.a("AEEditorTextControlPanel", "[show] not need show");
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369025) && (this.jdField_a_of_type_Bpjv != null)) {
      this.jdField_a_of_type_Bpjv.p();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    TextView localTextView = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a();
    if (localTextView != null) {
      localTextView.removeCallbacks(null);
    }
    super.onDetachedFromWindow();
  }
  
  public void setImageInfo(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setIsChooseImage(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedCreateThumbImage(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bpkf != null) {
      this.jdField_a_of_type_Bpkf.a(paramInt);
    }
  }
  
  public void setStickerCount(int paramInt)
  {
    if (this.jdField_a_of_type_Bpkf != null) {
      this.jdField_a_of_type_Bpkf.c(paramInt);
    }
  }
  
  public void setTextStickerControlListener(bpjv parambpjv)
  {
    this.jdField_a_of_type_Bpjv = parambpjv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel
 * JD-Core Version:    0.7.0.1
 */