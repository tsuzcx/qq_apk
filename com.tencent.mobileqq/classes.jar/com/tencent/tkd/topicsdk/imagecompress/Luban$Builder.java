package com.tencent.tkd.topicsdk.imagecompress;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class Luban$Builder
{
  private Context a;
  private String b;
  private int c = 100;
  private OnRenameListener d;
  private OnCompressListener e;
  private CompressionPredicate f;
  private List<InputStreamProvider> g;
  
  Luban$Builder(Context paramContext)
  {
    this.a = paramContext;
    this.g = new ArrayList();
  }
  
  private Luban b()
  {
    return new Luban(this, null);
  }
  
  public Builder a(OnCompressListener paramOnCompressListener)
  {
    this.e = paramOnCompressListener;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.g.add(new Luban.Builder.2(this, paramString));
    return this;
  }
  
  public void a()
  {
    Luban.a(b(), this.a);
  }
  
  public Builder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban.Builder
 * JD-Core Version:    0.7.0.1
 */