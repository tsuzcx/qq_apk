package cooperation.qqcircle.chat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

public class QCircleChatShareArkBubbleView
  extends LinearLayout
{
  public QCircleChatShareArkBubbleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleChatShareArkBubbleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleChatShareArkBubbleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void init(String paramString1, String paramString2, String paramString3)
  {
    setVisibility(8);
    View localView = inflate(getContext(), 2131558637, null);
    Object localObject = (ImageView)localView.findViewById(2131377264);
    Drawable localDrawable = getContext().getResources().getDrawable(2131167276);
    ((ImageView)localObject).setImageDrawable(URLDrawableHelper.getDrawable(paramString1, localDrawable, localDrawable));
    paramString1 = (TextView)localView.findViewById(2131377266);
    localObject = (TextView)localView.findViewById(2131377263);
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1.setVisibility(8);
      if (!TextUtils.isEmpty(paramString3)) {
        break label122;
      }
      ((TextView)localObject).setVisibility(8);
    }
    for (;;)
    {
      addView(localView);
      return;
      paramString1.setText(paramString2);
      break;
      label122:
      ((TextView)localObject).setText(paramString3);
    }
  }
  
  public void showBubble()
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    setAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleChatShareArkBubbleView
 * JD-Core Version:    0.7.0.1
 */