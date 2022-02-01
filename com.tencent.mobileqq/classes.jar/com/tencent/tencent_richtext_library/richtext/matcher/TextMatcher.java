package com.tencent.tencent_richtext_library.richtext.matcher;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TextMatcher
{
  private int a;
  protected String b;
  private boolean c = true;
  private int d = -1;
  private Matcher e;
  private Pattern f;
  private String g;
  
  protected TextMatcher(Pattern paramPattern)
  {
    this.f = paramPattern;
  }
  
  private void b()
  {
    if (this.c)
    {
      this.c = this.e.find();
      if (this.c) {
        this.d = this.e.start();
      }
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public abstract HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence);
  
  public boolean a(int paramInt)
  {
    if (this.g != null)
    {
      Matcher localMatcher = this.e;
      if (localMatcher == null) {
        return false;
      }
      int i = this.d;
      if (i <= paramInt)
      {
        if (!this.c) {
          return false;
        }
        if (i == paramInt)
        {
          this.b = localMatcher.group();
          this.a = this.e.end();
          b();
          return true;
        }
        b();
      }
    }
    return false;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
    this.e = this.f.matcher(paramString);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.TextMatcher
 * JD-Core Version:    0.7.0.1
 */