package com.tencent.mobileqq.listentogether.fragment;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.musicgene.AlbumDecodeHandler.OnDecodeCompleteCallback;

class ListenTogetherPlayFragment$1
  implements AlbumDecodeHandler.OnDecodeCompleteCallback
{
  ListenTogetherPlayFragment$1(ListenTogetherPlayFragment paramListenTogetherPlayFragment) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.getActivity().runOnUiThread(new ListenTogetherPlayFragment.1.1(this, paramString, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment.1
 * JD-Core Version:    0.7.0.1
 */