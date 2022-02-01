package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.ISpriteVideoViewTemp;
import com.qwallet.temp.ISpriteVideoViewTemp.OnFrameEndListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qqui.R.id;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.Iterator;
import java.util.List;

public class SpecifyGiftView
  extends RelativeLayout
{
  private ISpriteVideoViewTemp a;
  private View b;
  private ImageView c;
  private int d;
  private int e;
  private boolean f = true;
  private MessageForQQWalletMsg g;
  
  public SpecifyGiftView(Context paramContext, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    super(paramContext);
    this.g = paramMessageForQQWalletMsg;
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    this.a = ((ISpriteVideoViewTemp)QRoute.api(ISpriteVideoViewTemp.class));
    this.d = DisplayUtil.a(paramContext, 325.0F);
    this.e = DisplayUtil.a(paramContext, 350.0F);
    this.a.setPivotX(this.d / 2);
    this.a.setPivotY(this.e / 2);
    paramContext = new RelativeLayout(paramContext);
    paramContext.addView(this.a.getView());
    localLinearLayout.addView(paramContext);
    localObject = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = this.d;
    ((LinearLayout.LayoutParams)localObject).height = this.e;
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    this.a.setId(R.id.a);
    this.b = a(paramMessageForQQWalletMsg, localLinearLayout);
    paramMessageForQQWalletMsg = new ImageView(getContext());
    paramContext.addView(paramMessageForQQWalletMsg);
    paramContext = (RelativeLayout.LayoutParams)paramMessageForQQWalletMsg.getLayoutParams();
    paramContext.width = DisplayUtil.a(getContext(), 40.0F);
    paramContext.height = DisplayUtil.a(getContext(), 40.0F);
    paramContext.topMargin = DisplayUtil.a(getContext(), 20.0F);
    paramContext.addRule(7, R.id.a);
    paramContext.addRule(6, R.id.a);
    paramMessageForQQWalletMsg.setScaleType(ImageView.ScaleType.FIT_XY);
    int i = DisplayUtil.a(getContext(), 16.0F);
    paramMessageForQQWalletMsg.setPadding(i, 0, 0, i);
    paramMessageForQQWalletMsg.setImageResource(R.drawable.C);
    this.c = paramMessageForQQWalletMsg;
  }
  
  private View a(MessageForQQWalletMsg paramMessageForQQWalletMsg, LinearLayout paramLinearLayout)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (localBaseQQAppInterface == null) {
      return null;
    }
    int i = DisplayUtil.a(getContext(), 15.0F);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramLinearLayout.addView(localRelativeLayout);
    paramLinearLayout = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    paramLinearLayout.width = -2;
    paramLinearLayout.height = (DisplayUtil.a(getContext(), 100.0F) + i);
    paramLinearLayout.gravity = 1;
    paramLinearLayout = new LinearLayout(getContext());
    localRelativeLayout.addView(paramLinearLayout);
    paramLinearLayout.setBackgroundResource(R.drawable.ao);
    paramLinearLayout.setOrientation(1);
    Object localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = (DisplayUtil.a(getContext(), 70.0F) + i * 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    paramLinearLayout.setPadding(DisplayUtil.a(getContext(), 30.0F), i, DisplayUtil.a(getContext(), 30.0F), i);
    TextView localTextView1 = new TextView(getContext());
    localTextView1.setTextColor(-16777216);
    localTextView1.setTextSize(1, 11.0F);
    paramLinearLayout.addView(localTextView1);
    localObject1 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = -2;
    ((LinearLayout.LayoutParams)localObject1).height = -2;
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(getContext(), 20.0F);
    TextView localTextView2 = new TextView(getContext());
    localTextView2.setTextColor(-16777216);
    localTextView2.setTextSize(1, 18.0F);
    paramLinearLayout.addView(localTextView2);
    paramLinearLayout = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
    paramLinearLayout.width = -2;
    paramLinearLayout.height = -2;
    paramLinearLayout.gravity = 1;
    paramLinearLayout = new LinearLayout(getContext());
    paramLinearLayout.setOrientation(0);
    localRelativeLayout.addView(paramLinearLayout);
    localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    i = DisplayUtil.a(getContext(), 1.0F);
    ImageView localImageView = new ImageView(getContext());
    paramLinearLayout.addView(localImageView);
    localObject1 = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = DisplayUtil.a(getContext(), 40.0F);
    ((LinearLayout.LayoutParams)localObject1).height = DisplayUtil.a(getContext(), 40.0F);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setPadding(i, i, i, i);
    localImageView.setBackgroundResource(R.drawable.an);
    View localView = new View(getContext());
    paramLinearLayout.addView(localView);
    localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = DisplayUtil.a(getContext(), 13.0F);
    ((LinearLayout.LayoutParams)localObject1).height = DisplayUtil.a(getContext(), 10.0F);
    ((LinearLayout.LayoutParams)localObject1).leftMargin = DisplayUtil.a(getContext(), 13.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(getContext(), 23.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    localObject1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
    long l;
    while (((Iterator)localObject1).hasNext())
    {
      l = ((Long)((Iterator)localObject1).next()).longValue();
      localObject2 = new ImageView(getContext());
      paramLinearLayout.addView((View)localObject2);
      localObject3 = (LinearLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).width = DisplayUtil.a(getContext(), 40.0F);
      ((LinearLayout.LayoutParams)localObject3).height = DisplayUtil.a(getContext(), 40.0F);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = (-DisplayUtil.a(getContext(), 10.0F));
      ((ImageView)localObject2).setImageDrawable(FaceDrawable.getUserFaceDrawable(localBaseQQAppInterface, String.valueOf(l), (byte)3));
      ((ImageView)localObject2).setBackgroundResource(R.drawable.an);
      ((ImageView)localObject2).setPadding(i, i, i, i);
    }
    paramLinearLayout = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramMessageForQQWalletMsg.senderuin, true);
    Object localObject3 = QWalletTools.a(getContext(), paramLinearLayout, 90.0F, localTextView1.getPaint());
    Object localObject2 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
    paramLinearLayout = "";
    i = 0;
    for (;;)
    {
      localObject1 = paramLinearLayout;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      l = ((Long)((Iterator)localObject2).next()).longValue();
      localObject1 = (IContactUtilsApi)QRoute.api(IContactUtilsApi.class);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(l);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((IContactUtilsApi)localObject1).getBuddyName(((StringBuilder)localObject4).toString(), true);
      if (i > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLinearLayout);
        ((StringBuilder)localObject1).append("、");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = paramLinearLayout;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject4);
      localObject1 = localStringBuilder.toString();
      if ((i <= 0) || (((String)localObject1).length() <= 13)) {
        paramLinearLayout = (LinearLayout)localObject1;
      }
      i += 1;
      if (i >= 2)
      {
        localObject1 = paramLinearLayout;
        break;
      }
    }
    paramLinearLayout = new StringBuilder();
    paramLinearLayout.append((String)localObject3);
    paramLinearLayout.append(HardCodeUtil.a(R.string.cT));
    paramLinearLayout.append((String)localObject1);
    localObject2 = paramLinearLayout.toString();
    i = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size();
    paramLinearLayout = (LinearLayout)localObject2;
    if (i >= 2)
    {
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append((String)localObject2);
      paramLinearLayout.append(HardCodeUtil.a(R.string.cQ));
      paramLinearLayout.append(i);
      paramLinearLayout.append(HardCodeUtil.a(R.string.cR));
      paramLinearLayout = paramLinearLayout.toString();
    }
    paramLinearLayout = new SpannableStringBuilder(paramLinearLayout);
    paramLinearLayout.setSpan(new ForegroundColorSpan(-1694379), 0, ((String)localObject3).length(), 33);
    paramLinearLayout.setSpan(new StyleSpan(1), 0, ((String)localObject3).length(), 33);
    paramLinearLayout.setSpan(new ForegroundColorSpan(-1694379), ((String)localObject3).length() + 2, ((String)localObject3).length() + 3 + ((String)localObject1).length(), 33);
    paramLinearLayout.setSpan(new StyleSpan(1), ((String)localObject3).length() + 2, ((String)localObject3).length() + 3 + ((String)localObject1).length(), 33);
    localTextView1.setText(paramLinearLayout);
    localTextView1.setMaxLines(1);
    localTextView2.setText(HardCodeUtil.a(R.string.cS));
    localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(localBaseQQAppInterface, String.valueOf(paramMessageForQQWalletMsg.senderuin), (byte)3));
    localView.setBackgroundResource(R.drawable.am);
    return localRelativeLayout;
  }
  
  public void a()
  {
    ISpriteVideoViewTemp localISpriteVideoViewTemp = this.a;
    if (localISpriteVideoViewTemp != null) {
      localISpriteVideoViewTemp.stop();
    }
  }
  
  public void a(String paramString, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener, View.OnClickListener paramOnClickListener)
  {
    if (this.f)
    {
      this.a.play(paramString, paramOnFrameEndListener);
      paramString = this.b;
      if (paramString != null)
      {
        paramString.setAlpha(0.0F);
        this.b.animate().alpha(1.0F).setDuration(500L).start();
      }
    }
    else if (paramOnFrameEndListener != null)
    {
      paramOnFrameEndListener.a();
    }
    this.c.setOnClickListener(new SpecifyGiftView.1(this, paramOnFrameEndListener, paramOnClickListener));
    QWalletTools.a(this.c, 0.6F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyGiftView
 * JD-Core Version:    0.7.0.1
 */