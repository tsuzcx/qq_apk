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
import cooperation.qzone.contentbox.model.BottomItem;
import java.util.ArrayList;

public class FootNavigationLayout
  extends LinearLayout
{
  private static final int ACTION_TYPE = 7;
  private static final int MAX_ITEM = 3;
  private static final int[] SUB_ACTION_TYPE = { 4, 5, 6 };
  private ImageView[] arrows;
  private ViewGroup container;
  private View[] dividers;
  private ViewGroup[] items;
  private TextView[] texts;
  
  public FootNavigationLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131562349, this);
    this.container = ((ViewGroup)findViewById(2131369038));
    this.items = new ViewGroup[] { (ViewGroup)findViewById(2131366716), (ViewGroup)findViewById(2131376972), (ViewGroup)findViewById(2131378574) };
    this.arrows = new ImageView[] { (ImageView)findViewById(2131366717), (ImageView)findViewById(2131376973), (ImageView)findViewById(2131378575) };
    this.texts = new TextView[] { (TextView)findViewById(2131366718), (TextView)findViewById(2131376974), (TextView)findViewById(2131378576) };
    this.dividers = new View[] { null, findViewById(2131365667), findViewById(2131365668) };
  }
  
  public void setArrowVisible(int paramInt)
  {
    ImageView[] arrayOfImageView = this.arrows;
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
      this.container.setBackgroundColor(-15263977);
      localObject1 = this.texts;
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
      localObject1 = this.arrows;
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setBackgroundResource(2130848378);
        }
        i += 1;
      }
    }
    this.container.setBackgroundColor(-1);
    Object localObject1 = this.texts;
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
    localObject1 = this.arrows;
    j = localObject1.length;
    i = k;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setBackgroundResource(2130848377);
      }
      i += 1;
    }
  }
  
  public void updateData(ArrayList<BottomItem> paramArrayList)
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
      localViewGroup = this.items[i];
      localTextView = this.texts[i];
      localView = this.dividers[i];
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
      BottomItem localBottomItem = (BottomItem)paramArrayList.get(i);
      if ((localBottomItem == null) || (TextUtils.isEmpty(localBottomItem.content)) || (TextUtils.isEmpty(localBottomItem.content.trim())))
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
            localTextView.setText(localBottomItem.content);
          }
          localViewGroup.setOnClickListener(new FootNavigationLayout.1(this, localBottomItem, i));
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.FootNavigationLayout
 * JD-Core Version:    0.7.0.1
 */