package com.tencent.mobileqq.utils;

import java.lang.ref.WeakReference;

class ApolloLottieAnim$DecoderRunnable
  implements Runnable
{
  private String a;
  private String b;
  private boolean c;
  private WeakReference<ApolloLottieAnim> d;
  
  public void a(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = new WeakReference(paramApolloLottieAnim);
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.d;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ApolloLottieAnim.a((ApolloLottieAnim)this.d.get(), this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */