package com.tencent.mobileqq.wink.editor.music.lyric.data;

import android.graphics.Paint;
import java.util.ArrayList;

public class Sentence
{
  public String a;
  public long b;
  public long c;
  public ArrayList<SentenceUI> d = new ArrayList();
  public SentenceAttachInfo e = new SentenceAttachInfo();
  public SentenceAttachInfo f = new SentenceAttachInfo();
  public ArrayList<Character> g;
  
  public Sentence() {}
  
  public Sentence(SentenceUI paramSentenceUI)
  {
    if (paramSentenceUI == null) {
      return;
    }
    this.a = paramSentenceUI.a;
    this.g = paramSentenceUI.e;
    this.b = paramSentenceUI.a();
    this.c = (paramSentenceUI.b() - paramSentenceUI.a());
  }
  
  public Sentence a()
  {
    Sentence localSentence = new Sentence();
    localSentence.a = this.a;
    localSentence.c = this.c;
    localSentence.b = this.b;
    if (this.g != null)
    {
      localSentence.g = new ArrayList();
      localSentence.g.addAll(this.g);
    }
    localSentence.d.addAll(this.d);
    return localSentence;
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramPaint1;
    Object localObject2 = paramPaint2;
    int i = paramInt;
    this.d.clear();
    int j = (int)((Paint)localObject1).measureText(this.a);
    int k = (int)((Paint)localObject2).measureText(this.a);
    int i3 = 0;
    if (j <= i)
    {
      if (paramBoolean2)
      {
        paramInt = 0;
        i = 0;
      }
      else
      {
        paramInt = i - (int)((Paint)localObject2).measureText(this.a) >> 1;
        i = i - j >> 1;
      }
      paramPaint1 = new SentenceUI(this.a, paramInt, i, k, j, this.g);
      this.d.add(paramPaint1);
      return;
    }
    if (paramBoolean1)
    {
      paramPaint1 = new SentenceUI(this.a, 0, 0, k, j, this.g);
      this.d.add(paramPaint1);
      return;
    }
    localObject2 = LyricDataUtil.a(this.a, (Paint)localObject1, i, i);
    i = localObject2.length;
    if (i > 0)
    {
      int i2 = 0;
      j = 0;
      int i4 = 0;
      k = 0;
      int m = 0;
      int i6 = 0;
      int i5 = 0;
      for (;;)
      {
        int n = paramInt;
        if (i3 >= i) {
          break;
        }
        int i1;
        if (!paramBoolean2)
        {
          i5 = (int)paramPaint2.measureText(localObject2[i3]);
          i1 = (int)paramPaint1.measureText(localObject2[i3]);
          i5 = n - i5 >> 1;
          i6 = n - i1 >> 1;
        }
        localObject1 = null;
        if (this.g != null)
        {
          int i7 = i2 + localObject2[i3].length();
          localObject1 = new ArrayList();
          i1 = m;
          i2 = k;
          n = j;
          j = i7;
          while (n < this.g.size())
          {
            Character localCharacter = (Character)this.g.get(n);
            m = i2;
            k = i1;
            if (i3 != 0)
            {
              m = i2;
              k = i1;
              if (i4 == n)
              {
                m = j - localObject2[i3].length();
                i1 = localCharacter.c;
                k = m;
                m = i1 - m;
              }
            }
            if ((localCharacter.c <= j) && (localCharacter.d >= j))
            {
              if (i3 == 0)
              {
                ((ArrayList)localObject1).add(new Character(localCharacter.a, localCharacter.b, localCharacter.c, localObject2[i3].length()));
              }
              else
              {
                i1 = localCharacter.c;
                i2 = localObject2[i3].length();
                ((ArrayList)localObject1).add(new Character(localCharacter.a, localCharacter.b, i1 - k - m, i2));
              }
              n += 1;
              i4 = n;
              i1 = k;
              break label637;
            }
            if (i3 == 0)
            {
              ((ArrayList)localObject1).add(localCharacter);
            }
            else
            {
              i1 = localCharacter.c;
              i2 = localCharacter.d;
              ((ArrayList)localObject1).add(new Character(localCharacter.a, localCharacter.b, i1 - k - m, i2 - k - m));
            }
            n += 1;
            i2 = m;
            i1 = k;
          }
          m = i2;
        }
        else
        {
          i1 = m;
          m = k;
          n = j;
          j = i2;
        }
        label637:
        localObject1 = new SentenceUI(localObject2[i3], i5, i6, (ArrayList)localObject1);
        this.d.add(localObject1);
        i3 += 1;
        i2 = j;
        j = n;
        k = m;
        m = i1;
      }
    }
  }
  
  public int b()
  {
    return this.d.size();
  }
  
  public ArrayList<SentenceUI> c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.data.Sentence
 * JD-Core Version:    0.7.0.1
 */