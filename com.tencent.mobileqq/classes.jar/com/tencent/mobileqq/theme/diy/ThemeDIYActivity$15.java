package com.tencent.mobileqq.theme.diy;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$15
  implements AdapterView.OnItemClickListener
{
  ThemeDIYActivity$15(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ItemView)paramView;
    if ((paramAdapterView == null) || (paramAdapterView.resSuitData == null))
    {
      QLog.e("ThemeDIYActivity", 1, "resItemClickListener onItemClick, null == itemView , position:" + paramInt + ", itemView:" + paramAdapterView);
      return;
    }
    if ((paramAdapterView.resSuitData instanceof ResSuitData.BgSuit))
    {
      paramView = (ResSuitData.BgSuit)paramAdapterView.resSuitData;
      Object localObject;
      if ("99".equals(paramView.id))
      {
        paramAdapterView = this.this$0.getIntent();
        localObject = DIYThemeUtils.getResData(this.this$0.app, this.this$0.mUploadBgRSD, 121, this.this$0.mUploadBgRSD.id + "." + this.this$0.mCurrentPageIndex + "." + System.currentTimeMillis()).path;
        Rect localRect = new Rect();
        this.this$0.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        paramAdapterView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        int k = localRect.width();
        int j = localRect.height();
        int i = k;
        paramInt = j;
        if (this.this$0.mCurrentPageIndex != 2)
        {
          i = k * 3 / 4;
          paramInt = j * 3 / 4;
        }
        PhotoUtils.a(paramAdapterView, this.this$0, ThemeDIYActivity.class.getName(), localRect.width() * 4 / 5, localRect.height() * 4 / 5, i, paramInt, (String)localObject);
        paramAdapterView = "diy_photo";
      }
      for (;;)
      {
        ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", paramAdapterView, 0, 0, String.valueOf(this.this$0.mCurrentPageIndex), paramView.id, "" + paramView.from, "");
        return;
        this.this$0.mPageView.mData.tryOnBgRSD = paramView;
        this.this$0.setListItemStatus(this.this$0.bgResHListView, this.this$0.mPageView.mData.tryOnBgRSD, this.this$0.mPageView.mData.usedBgRSD, null);
        localObject = DIYThemeUtils.getResData(null, paramView, 117, paramView.thumbnail);
        if ("100".equals(paramView.id))
        {
          paramAdapterView = "Diy_default";
          this.this$0.mPageView.showPic(this.this$0.mPageView.mData.defaultBgRSD, null, true, null);
          ((ResData)localObject).resID = paramView.resID;
          this.this$0.blurBg((ResData)localObject, this.this$0.mPageView.bgDrawable, 1, false);
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(paramView.id)) || (paramView.id.equals(this.this$0.mPageView.mData.usedBgRSD.id))) {
            break label660;
          }
          this.this$0.mPageView.mData.mSetStatus = 2;
          break;
          this.this$0.mPageView.showPic(paramView, null, true, null);
          if (paramAdapterView.mThumImg != null) {}
          for (paramAdapterView = paramAdapterView.mThumImg.getBackground();; paramAdapterView = null)
          {
            if ((paramAdapterView != null) && ((paramAdapterView instanceof URLDrawable)) && (((URLDrawable)paramAdapterView).getStatus() == 1)) {
              break label641;
            }
            this.this$0.mPageView.bgDrawable = null;
            this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 19, localObject));
            paramAdapterView = "diy_yangtu";
            break;
          }
          label641:
          this.this$0.blurBg((ResData)localObject, paramAdapterView, 1, true);
          paramAdapterView = "diy_yangtu";
        }
        label660:
        this.this$0.mPageView.mData.mSetStatus = 0;
      }
    }
    if ((paramAdapterView.resSuitData instanceof ResSuitData.StyleSuit))
    {
      paramAdapterView = (ResSuitData.StyleSuit)paramAdapterView.resSuitData;
      this.this$0.tryOnStyleRSD = paramAdapterView;
      this.this$0.setListItemStatus(this.this$0.styleResHListView, this.this$0.tryOnStyleRSD, this.this$0.usedStyleRSD, null);
      paramInt = 0;
      while (paramInt < this.this$0.mScrollLayout.getChildCount())
      {
        ((PageView)this.this$0.mScrollLayout.getChildAt(paramInt)).showPic(paramAdapterView, null, true, null);
        paramInt += 1;
      }
      if ((this.this$0.mUserThemeId == null) || (!this.this$0.mUserThemeId.equals(paramAdapterView.id))) {}
      for (this.this$0.mStyleSetStatus = 2;; this.this$0.mStyleSetStatus = 0)
      {
        this.this$0.mAdapter.tryOnStyleRSD = this.this$0.tryOnStyleRSD;
        ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "diy_style", 0, 0, String.valueOf(this.this$0.mCurrentPageIndex), paramAdapterView.id, "", "");
        if (this.this$0.mCurrentPageIndex != 0) {
          break;
        }
        this.this$0.mScrollLayout.snapToScreen(1);
        this.this$0.onScreenChange(1);
        return;
      }
    }
    QLog.e("ThemeDIYActivity", 1, "resItemClickListener itemView.resSuitData Type Error position:" + paramInt + ", itemView.resSuitData:" + paramAdapterView.resSuitData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.15
 * JD-Core Version:    0.7.0.1
 */