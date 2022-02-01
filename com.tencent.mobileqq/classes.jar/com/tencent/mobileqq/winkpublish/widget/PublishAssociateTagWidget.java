package com.tencent.mobileqq.winkpublish.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;

public class PublishAssociateTagWidget
  extends PublishBaseWidgetView
{
  TextView a;
  TextView b;
  
  public PublishAssociateTagWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof FeedCloudMeta.StTagInfo)))
    {
      setVisibility(0);
      TextView localTextView = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      paramObject = (FeedCloudMeta.StTagInfo)paramObject;
      localStringBuilder.append(paramObject.tagName.get());
      localTextView.setText(localStringBuilder.toString());
      this.b.setText(paramObject.tagDec.get());
    }
    else
    {
      setVisibility(8);
    }
    setOnClickListener(new PublishAssociateTagWidget.1(this));
  }
  
  public int getLayoutId()
  {
    return 2131627224;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131446838));
    this.b = ((TextView)paramView.findViewById(2131446837));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PublishAssociateTagWidget
 * JD-Core Version:    0.7.0.1
 */