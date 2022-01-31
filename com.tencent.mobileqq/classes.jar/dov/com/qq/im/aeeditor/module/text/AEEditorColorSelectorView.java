package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bloz;
import blpa;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class AEEditorColorSelectorView
  extends FrameLayout
{
  private final int jdField_a_of_type_Int = Color.parseColor("#ffffffff");
  private blpa jdField_a_of_type_Blpa;
  private final LinkedHashMap<Integer, ImageView> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private final int b = Color.parseColor("#ff2b2b2b");
  private final int c = Color.parseColor("#fffb5151");
  private final int d = Color.parseColor("#ffffc300");
  private final int e = Color.parseColor("#ff07c160");
  private final int f = Color.parseColor("#ff0faeff");
  private final int g = Color.parseColor("#ff5d5ad7");
  
  public AEEditorColorSelectorView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Drawable a(boolean paramBoolean, int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int i;
    int k;
    if (paramBoolean)
    {
      i = 2131298877;
      k = getResources().getDimensionPixelSize(2131298874);
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (int j = 0;; j = getResources().getDimensionPixelSize(2131298878))
    {
      j = k - j;
      localGradientDrawable.setColor(paramInt);
      localGradientDrawable.setStroke(getResources().getDimensionPixelSize(i), -1);
      localGradientDrawable.setSize(j, j);
      localGradientDrawable.setShape(1);
      return localGradientDrawable;
      i = 2131298878;
      break;
    }
  }
  
  private void a()
  {
    Object localObject1 = (ImageView)findViewById(2131366667);
    Object localObject2 = (ImageView)findViewById(2131366663);
    ImageView localImageView1 = (ImageView)findViewById(2131366664);
    ImageView localImageView2 = (ImageView)findViewById(2131366668);
    ImageView localImageView3 = (ImageView)findViewById(2131366666);
    ImageView localImageView4 = (ImageView)findViewById(2131366665);
    ImageView localImageView5 = (ImageView)findViewById(2131366662);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject1);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.b), localObject2);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.c), localImageView1);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.d), localImageView2);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.e), localImageView3);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.f), localImageView4);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(this.g), localImageView5);
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (ImageView)((Map.Entry)localObject2).getValue();
      ((ImageView)localObject2).setImageDrawable(a(false, i));
      ((ImageView)localObject2).setOnClickListener(new bloz(this, i));
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Blpa != null) {
      this.jdField_a_of_type_Blpa.a(paramInt);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ImageView localImageView = (ImageView)localEntry.getValue();
      if (paramInt == ((Integer)localEntry.getKey()).intValue()) {
        localImageView.setImageDrawable(a(true, ((Integer)localEntry.getKey()).intValue()));
      } else {
        localImageView.setImageDrawable(a(false, ((Integer)localEntry.getKey()).intValue()));
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View.inflate(getContext(), 2131560599, this);
    a();
  }
  
  public void setColorSelectedListener(blpa paramblpa)
  {
    this.jdField_a_of_type_Blpa = paramblpa;
  }
  
  public void setSelectedColor(int paramInt)
  {
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView
 * JD-Core Version:    0.7.0.1
 */