package com.tencent.mobileqq.extendfriend.fragment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;

class ExtendFriendApolloGuideDialogFragment$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  ExtendFriendApolloGuideDialogFragment$1(ExtendFriendApolloGuideDialogFragment paramExtendFriendApolloGuideDialogFragment) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      ExtendFriendApolloGuideDialogFragment.a(this.a).setImageDrawable((Drawable)null);
      ExtendFriendApolloGuideDialogFragment.a(this.a).setImageDrawable(ExtendFriendApolloGuideDialogFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendApolloGuideDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */