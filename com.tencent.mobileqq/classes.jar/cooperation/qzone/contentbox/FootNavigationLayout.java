package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bjee;
import bjew;
import java.util.ArrayList;

public class FootNavigationLayout
  extends LinearLayout
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4, 5, 6 };
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private ViewGroup[] jdField_a_of_type_ArrayOfAndroidViewViewGroup;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  
  public FootNavigationLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131562179, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368585));
    this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = new ViewGroup[] { (ViewGroup)findViewById(2131366382), (ViewGroup)findViewById(2131376249), (ViewGroup)findViewById(2131377757) };
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { (ImageView)findViewById(2131366383), (ImageView)findViewById(2131376250), (ImageView)findViewById(2131377758) };
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[] { (TextView)findViewById(2131366384), (TextView)findViewById(2131376251), (TextView)findViewById(2131377759) };
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { null, findViewById(2131365355), findViewById(2131365356) };
  }
  
  public void a(ArrayList<bjew> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    int i = 0;
    label20:
    ViewGroup localViewGroup;
    TextView localTextView;
    View localView;
    if (i < 3)
    {
      localViewGroup = this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i];
      localTextView = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i];
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
      if (i < paramArrayList.size()) {
        break label85;
      }
      if (localViewGroup != null) {
        localViewGroup.setVisibility(8);
      }
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label85:
      bjew localbjew = (bjew)paramArrayList.get(i);
      if ((localbjew == null) || (TextUtils.isEmpty(localbjew.a)) || (TextUtils.isEmpty(localbjew.a.trim())))
      {
        if (localViewGroup != null) {
          localViewGroup.setVisibility(8);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      else
      {
        if (localViewGroup != null)
        {
          localViewGroup.setVisibility(0);
          if (localTextView != null) {
            localTextView.setText(localbjew.a);
          }
          localViewGroup.setOnClickListener(new bjee(this, localbjew, i));
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
    }
  }
  
  public void setArrowVisible(int paramInt)
  {
    ImageView[] arrayOfImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
    int j = arrayOfImageView.length;
    int i = 0;
    while (i < j)
    {
      ImageView localImageView = arrayOfImageView[i];
      if (localImageView != null) {
        localImageView.setVisibility(paramInt);
      }
      i += 1;
    }
  }
  
  public void setNightMode(boolean paramBoolean)
  {
    int k = 0;
    int j = 0;
    Object localObject2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-15263977);
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView;
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setTextColor(-1);
        }
        i += 1;
      }
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setBackgroundResource(2130847899);
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView;
    j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setTextColor(-16777216);
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
    j = localObject1.length;
    i = k;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setBackgroundResource(2130847898);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.FootNavigationLayout
 * JD-Core Version:    0.7.0.1
 */