package com.tencent.mobileqq.theme.diy;

import android.text.TextUtils;
import azqs;
import bevu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class ThemeDIYActivity$2
  implements bevu
{
  ThemeDIYActivity$2(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    Object localObject1;
    boolean bool;
    if ((this.this$0.mIsUserClickTab.get()) && ((3 == paramInt2) || (1 == paramInt2)))
    {
      localObject2 = this.this$0.app;
      String str = this.this$0.app.getCurrentAccountUin();
      if (3 == paramInt2)
      {
        localObject1 = "diy_clickstyle";
        azqs.b((QQAppInterface)localObject2, "CliOper", "", str, "theme_mall", (String)localObject1, 0, 1, "", "", "", "");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("mTypeTabChangeListener onTabSelected, oldPosition = ").append(paramInt1).append(" currPosition = ").append(paramInt2).append(" styleResHListView is null ? ");
        if (this.this$0.styleResHListView != null) {
          break label321;
        }
        bool = true;
        label128:
        localObject1 = ((StringBuilder)localObject1).append(String.valueOf(bool)).append(" bgResHListView is null ? ");
        if (this.this$0.bgResHListView != null) {
          break label326;
        }
        bool = true;
        label156:
        QLog.i("ThemeDIYActivity", 2, String.valueOf(bool));
      }
      this.this$0.mIsUserClickTab.set(true);
      if ((3 != paramInt2) || (this.this$0.styleResHListView != null)) {
        break label399;
      }
      if ((this.this$0.initStyleRSD == null) || ("999".equals(this.this$0.initStyleRSD.id))) {
        break label387;
      }
      localObject1 = new ArrayList();
      paramInt1 = 0;
      label239:
      if (paramInt1 >= this.this$0.mStyleSuits.size()) {
        break label342;
      }
      localObject2 = (ResSuitData)this.this$0.mStyleSuits.get(paramInt1);
      if ((!this.this$0.initStyleRSD.id.equals(((ResSuitData)localObject2).id)) || (((ArrayList)localObject1).size() < 2)) {
        break label331;
      }
      ((ArrayList)localObject1).add(1, localObject2);
    }
    for (;;)
    {
      paramInt1 += 1;
      break label239;
      localObject1 = "diy_clickbg";
      break;
      label321:
      bool = false;
      break label128;
      label326:
      bool = false;
      break label156;
      label331:
      ((ArrayList)localObject1).add(localObject2);
    }
    label342:
    this.this$0.bgResHListView = null;
    this.this$0.styleResHListView = this.this$0.mResHListView;
    this.this$0.mAdapter.mData = ((ArrayList)localObject1);
    this.this$0.mAdapter.notifyDataSetChanged();
    label387:
    label399:
    while ((1 != paramInt2) || (this.this$0.bgResHListView != null)) {
      for (;;)
      {
        return;
        localObject1 = this.this$0.mStyleSuits;
      }
    }
    this.this$0.bgResHListView = this.this$0.mResHListView;
    this.this$0.styleResHListView = null;
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(this.this$0.mUploadBgRSD);
    ((ArrayList)localObject2).add(this.this$0.mPageView.mData.defaultBgRSD);
    if (this.this$0.initStyleRSD != null)
    {
      localObject1 = (ResSuitData.StyleSuit)this.this$0.initStyleRSD;
      if ((localObject1 != null) && (((ResSuitData.StyleSuit)localObject1).bgSuits != null)) {
        ((ArrayList)localObject2).addAll(((ResSuitData.StyleSuit)localObject1).bgSuits);
      }
      ((ArrayList)localObject2).addAll(this.this$0.mBgSuits);
      if ((this.this$0.mPageView.mData.initBgRSD != null) && (!TextUtils.isEmpty(this.this$0.mPageView.mData.initBgRSD.id)))
      {
        paramInt1 = 2;
        label576:
        if (paramInt1 >= ((ArrayList)localObject2).size()) {
          break label700;
        }
        localObject1 = (ResSuitData)((ArrayList)localObject2).get(paramInt1);
        if (!this.this$0.mPageView.mData.initBgRSD.id.equals(((ResSuitData)localObject1).id)) {
          break label693;
        }
        ((ArrayList)localObject2).remove(localObject1);
        ((ArrayList)localObject2).add(2, localObject1);
      }
    }
    label693:
    label700:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        ((ArrayList)localObject2).add(2, this.this$0.mPageView.mData.initBgRSD);
      }
      this.this$0.mAdapter.mData = ((ArrayList)localObject2);
      this.this$0.mAdapter.notifyDataSetChanged();
      return;
      localObject1 = null;
      break;
      paramInt1 += 1;
      break label576;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.2
 * JD-Core Version:    0.7.0.1
 */