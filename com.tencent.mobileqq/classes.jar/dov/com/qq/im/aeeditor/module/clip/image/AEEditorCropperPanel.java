package dov.com.qq.im.aeeditor.module.clip.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.List;

public class AEEditorCropperPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AEEditorCropperPanel.CropChangeCallback jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback;
  private AEEditorCropperRatioButton jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton;
  private AEImageCropperContainer jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer;
  private List<AEEditorImageInfo> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private AEEditorCropperRatioButton jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton;
  private int jdField_c_of_type_Int = 0;
  private AEEditorCropperRatioButton jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton;
  private AEEditorCropperRatioButton d;
  private AEEditorCropperRatioButton e;
  
  public AEEditorCropperPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorCropperPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorCropperPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramInt1 * 1.0F / paramInt2 <= (paramRect.right - paramRect.left) * 1.0F / (paramRect.bottom - paramRect.top)) {
      return (paramRect.right - paramRect.left) * 1.0F / paramInt1;
    }
    return (paramRect.bottom - paramRect.top) * 1.0F / paramInt2;
  }
  
  public static CropConfig a(int paramInt1, int paramInt2)
  {
    float f4 = 0.0F;
    float f3 = 1.0F;
    double d1 = paramInt1 * 1.0F / paramInt2;
    float f2;
    float f1;
    if (d1 <= 0.333333343267441D)
    {
      f2 = (paramInt2 - paramInt1 / 0.3333333F) * 1.0F / 2.0F / paramInt2;
      f1 = paramInt1 / 0.3333333F * 1.0F / paramInt2;
    }
    for (;;)
    {
      return new CropConfig(f4, f2, f3, f1);
      if (d1 >= 1.777777791023254D)
      {
        f4 = (paramInt1 - paramInt2 * 1.777778F) * 1.0F / 2.0F / paramInt1;
        f3 = paramInt2 * 1.777778F * 1.0F / paramInt1;
        f1 = 1.0F;
        f2 = 0.0F;
      }
      else
      {
        f1 = 1.0F;
        f2 = 0.0F;
      }
    }
  }
  
  private void a(int paramInt)
  {
    c();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      return;
    case 1: 
      this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      return;
    case 2: 
      this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      return;
    case 3: 
      this.d.setChecked(true);
      return;
    }
    this.e.setChecked(true);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_JavaLangString, 1440, 1440), (AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int), paramInt1, paramInt2);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2131558577, this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer = ((AEImageCropperContainer)paramContext.findViewById(2131362324));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131365469));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131365470));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton = ((AEEditorCropperRatioButton)paramContext.findViewById(2131366191));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setText(getResources().getString(2131689741));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setOnClickListener(this);
    this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton = ((AEEditorCropperRatioButton)paramContext.findViewById(2131366192));
    this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setText("1 : 1");
    this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setBackImg(2130837977);
    this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setOnClickListener(this);
    this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton = ((AEEditorCropperRatioButton)paramContext.findViewById(2131366193));
    this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setText("3 : 4");
    this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setBackImg(2130837978);
    this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setOnClickListener(this);
    this.d = ((AEEditorCropperRatioButton)paramContext.findViewById(2131366194));
    this.d.setText("4 : 3");
    this.d.setBackImg(2130837979);
    this.d.setOnClickListener(this);
    this.e = ((AEEditorCropperRatioButton)paramContext.findViewById(2131366195));
    this.e.setText("16 : 9");
    this.e.setBackImg(2130837976);
    this.e.setOnClickListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(false);
    this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(false);
    this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(false);
    this.d.setChecked(false);
    this.e.setChecked(false);
  }
  
  public CropConfig a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
    }
    if (paramInt3 == 0) {
      return a(paramInt1, paramInt2);
    }
    Rect localRect = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a.a();
    if (localRect == null) {
      return a(paramInt1, paramInt2);
    }
    float f1 = a(paramInt1, paramInt2, localRect);
    float f2 = (paramInt1 * f1 - (localRect.right - localRect.left)) * 1.0F / 2.0F;
    float f3 = (paramInt2 * f1 - (localRect.bottom - localRect.top)) * 1.0F / 2.0F;
    return new CropConfig(f2 / (paramInt1 * f1), f3 / (paramInt2 * f1), (localRect.right - localRect.left) * 1.0F / (paramInt1 * f1), (localRect.bottom - localRect.top) * 1.0F / (f1 * paramInt2));
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a();
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(null);
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(this.jdField_c_of_type_Int);
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a());
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback.b();
    }
    if (this.jdField_c_of_type_Int != this.jdField_b_of_type_Int)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (i == this.jdField_a_of_type_Int) {}
        for (;;)
        {
          i += 1;
          break;
          ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_c_of_type_Int);
          ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a(a(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int, ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int, this.jdField_c_of_type_Int));
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() > 1) && (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback != null)) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback.a();
      }
    }
  }
  
  public void a(List<AEEditorImageInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer != null)
    {
      setVisibility(0);
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Int = paramInt1;
      paramInt1 = ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).a();
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt1;
      a(this.jdField_b_of_type_Int);
      a(paramInt2, paramInt3);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      AEReportUtils.b(3, this.jdField_c_of_type_Int);
      continue;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback.c();
      }
      AEReportUtils.b(2, this.jdField_c_of_type_Int);
      continue;
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
      c();
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      AEReportUtils.b(1, this.jdField_c_of_type_Int);
      continue;
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
      c();
      this.jdField_b_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      AEReportUtils.b(1, this.jdField_c_of_type_Int);
      continue;
      this.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
      c();
      this.jdField_c_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      AEReportUtils.b(1, this.jdField_c_of_type_Int);
      continue;
      this.jdField_c_of_type_Int = 3;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
      c();
      this.d.setChecked(true);
      AEReportUtils.b(1, this.jdField_c_of_type_Int);
      continue;
      this.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
      c();
      this.e.setChecked(true);
      AEReportUtils.b(1, this.jdField_c_of_type_Int);
    }
  }
  
  public void setCropChangeCallBack(AEEditorCropperPanel.CropChangeCallback paramCropChangeCallback)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback = paramCropChangeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEEditorCropperPanel
 * JD-Core Version:    0.7.0.1
 */