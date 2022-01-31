package io.flutter.embedding.android;

import android.support.v4.app.FragmentActivity;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;

class FlutterFragment$1
  implements OnFirstFrameRenderedListener
{
  FlutterFragment$1(FlutterFragment paramFlutterFragment) {}
  
  public void onFirstFrameRendered()
  {
    this.this$0.onFirstFrameRendered();
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity instanceof OnFirstFrameRenderedListener)) {
      ((OnFirstFrameRenderedListener)localFragmentActivity).onFirstFrameRendered();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment.1
 * JD-Core Version:    0.7.0.1
 */