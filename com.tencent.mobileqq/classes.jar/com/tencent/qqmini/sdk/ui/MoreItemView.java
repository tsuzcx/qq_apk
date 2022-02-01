package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;

public class MoreItemView
  extends LinearLayout
{
  private static final String TAG = "MoreItemView";
  private MoreItem mMoreItem;
  private ImageView mMoreItemImage;
  private TextView mMoreItemText;
  
  public MoreItemView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    View localView = inflate(getContext(), R.layout.mini_sdk_more_item_view, this);
    this.mMoreItemImage = ((ImageView)localView.findViewById(R.id.more_item_image));
    this.mMoreItemText = ((TextView)localView.findViewById(R.id.more_item_text));
  }
  
  public void bind(MoreItem paramMoreItem)
  {
    if (paramMoreItem == null)
    {
      QMLog.w("MoreItemView", "bind. Failed to bind data. MoreItem is null");
      return;
    }
    if ((paramMoreItem.drawable != 0) && (paramMoreItem.text != null))
    {
      this.mMoreItem = paramMoreItem;
      this.mMoreItemImage.setImageDrawable(getResources().getDrawable(paramMoreItem.drawable));
      this.mMoreItemText.setText(paramMoreItem.text);
      int i;
      if (paramMoreItem.visible) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      return;
    }
    QMLog.w("MoreItemView", "bind. Failed to bind data. MoreItem is null");
  }
  
  public MoreItem getMoreItem()
  {
    return this.mMoreItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreItemView
 * JD-Core Version:    0.7.0.1
 */