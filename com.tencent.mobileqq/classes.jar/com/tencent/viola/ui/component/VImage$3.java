package com.tencent.viola.ui.component;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.commons.ImageAdapterHolder.ImageListener;
import com.tencent.viola.ui.dom.DomObject;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class VImage$3
  implements ImageAdapterHolder.ImageListener
{
  VImage$3(VImage paramVImage, boolean paramBoolean) {}
  
  public void onImageFinish(String paramString, ImageView paramImageView, boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.val$shouldFinish) {}
    label245:
    do
    {
      return;
      this.this$0.imgReadHeight = ((VImage.Measurable)paramImageView).getNaturalHeight();
      this.this$0.imgRealWidth = ((VImage.Measurable)paramImageView).getNaturalWidth();
      if (paramBundle != null)
      {
        this.this$0.imgReadHeight = paramBundle.getInt(ImageAdapterHolder.BUNDLE_HEIGHT, this.this$0.imgReadHeight);
        this.this$0.imgRealWidth = paramBundle.getInt(ImageAdapterHolder.BUNDLE_WIDTH, this.this$0.imgRealWidth);
      }
      VImage.access$700(this.this$0);
      if ((this.this$0.getDomObject() != null) && (this.this$0.getDomObject().getEvents().contains("finish"))) {}
      try
      {
        paramString = new JSONObject();
        paramImageView = new JSONObject();
        paramImageView.put("width", this.this$0.imgRealWidth);
        paramImageView.put("height", this.this$0.imgReadHeight);
        if (!paramBoolean) {
          break;
        }
        i = 1;
        paramString.put("success", i);
        paramString.put("image", paramImageView);
        paramImageView = new JSONArray();
        paramBundle = this.this$0.mDomObj.getRef();
        if (!TextUtils.isEmpty(paramBundle)) {
          paramImageView.put(paramBundle);
        }
        paramImageView.put("finish");
        VImage.access$800(this.this$0, "finish", paramImageView, paramString);
      }
      catch (Exception paramString)
      {
        int i;
        break label245;
      }
    } while ((!this.this$0.isVGif()) || (this.this$0.getDomObject() == null) || (!this.this$0.getDomObject().getEvents().contains("beginPlay")));
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        paramImageView = new JSONObject();
        paramImageView.put("width", this.this$0.imgRealWidth);
        paramImageView.put("height", this.this$0.imgReadHeight);
        if (!paramBoolean) {
          break label413;
        }
        i = 1;
        paramString.put("success", i);
        paramString.put("image", paramImageView);
        paramImageView = new JSONArray();
        paramBundle = this.this$0.mDomObj.getRef();
        if (!TextUtils.isEmpty(paramBundle)) {
          paramImageView.put(paramBundle);
        }
        paramImageView.put("beginPlay");
        VImage.access$900(this.this$0, "beginPlay", paramImageView, paramString);
        return;
      }
      catch (Exception paramString)
      {
        return;
      }
      i = 0;
      break;
      label413:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VImage.3
 * JD-Core Version:    0.7.0.1
 */