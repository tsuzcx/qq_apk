package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.opengl.Matrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class GLViewContext
  implements SoundPool.OnLoadCompleteListener
{
  private float jdField_a_of_type_Float;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private BgmPlayer jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer;
  public BoyDataReport a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private float jdField_b_of_type_Float;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private final ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  public GLViewContext()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport = new BoyDataReport();
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer = new BgmPlayer();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GLViewContext.AudioItem)((Iterator)localObject1).next();
      if (((GLViewContext.AudioItem)localObject2).jdField_a_of_type_Int == paramInt1)
      {
        ((GLViewContext.AudioItem)localObject2).jdField_a_of_type_Boolean = true;
        ((GLViewContext.AudioItem)localObject2).b = paramInt2;
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (GLViewContext.AudioItem)((Iterator)localObject2).next();
      if (((GLViewContext.AudioItem)localObject1).jdField_a_of_type_Int == paramInt1) {
        a((GLViewContext.AudioItem)localObject1);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
      }
      return;
      localObject1 = null;
    }
  }
  
  private void a(GLViewContext.AudioItem paramAudioItem)
  {
    if (paramAudioItem.jdField_a_of_type_Boolean) {
      if (paramAudioItem.b == 0)
      {
        i = this.jdField_a_of_type_AndroidMediaSoundPool.play(paramAudioItem.jdField_a_of_type_Int, 1.0F, 1.0F, paramAudioItem.d, paramAudioItem.c, 1.0F);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(Integer.valueOf(i));
      }
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramAudioItem))
    {
      int i;
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAudioItem);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      GLViewContext.AudioItem localAudioItem = new GLViewContext.AudioItem(this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 1));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localAudioItem);
    }
    paramString = (GLViewContext.AudioItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString.c = paramInt1;
    paramString.d = paramInt2;
    a(paramString);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public final Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {}
    do
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.jdField_a_of_type_AndroidMediaSoundPool.stop(i);
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (GLViewContext.AudioItem)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        this.jdField_a_of_type_AndroidMediaSoundPool.unload(((GLViewContext.AudioItem)localObject).jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer = null;
  }
  
  public final void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    Matrix.orthoM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), 0.0F, 0.0F, 1.0F);
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.width() * 1.0F / this.jdField_b_of_type_AndroidGraphicsRect.width());
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.width() / 750.0F);
  }
  
  public final void a(RectF paramRectF)
  {
    float f = a();
    paramRectF.set(paramRectF.left * f, paramRectF.top * f, paramRectF.right * f, f * paramRectF.bottom);
  }
  
  public void a(String paramString)
  {
    a(paramString, 0, 1);
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_AndroidMediaSoundPool != null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(3, 3, 0);
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
      int i = 0;
      while (i < paramList.size())
      {
        GLViewContext.AudioItem localAudioItem = new GLViewContext.AudioItem(this.jdField_a_of_type_AndroidMediaSoundPool.load((String)paramList.get(i), 1));
        this.jdField_a_of_type_JavaUtilHashMap.put(paramList.get(i), localAudioItem);
        i += 1;
      }
    }
  }
  
  public float[] a()
  {
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public final Rect b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        GLViewContext.LoadItem[] arrayOfLoadItem = new GLViewContext.LoadItem[this.jdField_b_of_type_JavaUtilArrayList.size()];
        this.jdField_b_of_type_JavaUtilArrayList.toArray(arrayOfLoadItem);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int j = arrayOfLoadItem.length;
        int i = 0;
        if (i < j)
        {
          ??? = arrayOfLoadItem[i];
          if (??? != null) {
            a(???.jdField_a_of_type_Int, ???.b);
          }
          i += 1;
        }
      }
    }
  }
  
  public final void b(Rect paramRect)
  {
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public final void b(RectF paramRectF)
  {
    float f = a();
    paramRectF.set(paramRectF.left / f, paramRectF.top / f, paramRectF.right / f, paramRectF.bottom / f);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer.a(paramString);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.jdField_a_of_type_AndroidMediaSoundPool.stop(i);
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBgmPlayer.a();
    }
  }
  
  public void onLoadComplete(SoundPool arg1, int paramInt1, int paramInt2)
  {
    GLViewContext.LoadItem localLoadItem = new GLViewContext.LoadItem();
    localLoadItem.jdField_a_of_type_Int = paramInt1;
    localLoadItem.b = paramInt2;
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(localLoadItem);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext
 * JD-Core Version:    0.7.0.1
 */