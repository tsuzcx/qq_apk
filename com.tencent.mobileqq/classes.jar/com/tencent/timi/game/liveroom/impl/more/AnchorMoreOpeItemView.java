package com.tencent.timi.game.liveroom.impl.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.timi_game.impl.R.styleable;

public class AnchorMoreOpeItemView
  extends RelativeLayout
{
  public AnchorMoreOpeItemView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public AnchorMoreOpeItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public AnchorMoreOpeItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    inflate(paramContext, 2131629410, this);
    ImageView localImageView = (ImageView)findViewById(2131428326);
    TextView localTextView = (TextView)findViewById(2131428330);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.j);
      paramAttributeSet = paramContext.getDrawable(R.styleable.k);
      String str = paramContext.getString(R.styleable.l);
      if (paramAttributeSet != null)
      {
        localImageView.setImageDrawable(paramAttributeSet);
        localTextView.setText(str);
      }
      paramContext.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorMoreOpeItemView
 * JD-Core Version:    0.7.0.1
 */