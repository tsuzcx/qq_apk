package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GLFrameImage
  extends GLImageView
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private boolean e = true;
  
  public GLFrameImage(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static GLImage a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GLImage localGLImage2 = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    GLImage localGLImage1 = localGLImage2;
    if (localGLImage2 == null)
    {
      localGLImage1 = new GLImage(paramBoolean1, paramBoolean2);
      localGLImage1.a(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localGLImage1);
    }
    DanceLog.b("GLFrameImage", "getImageByPath");
    return localGLImage1;
  }
  
  public static void a(HashMap paramHashMap)
  {
    if (paramHashMap.size() > 0)
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GLImage localGLImage1 = (GLImage)paramHashMap.get(str);
        GLImage localGLImage2 = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localGLImage2 == null)
        {
          jdField_a_of_type_JavaUtilHashMap.put(str, localGLImage1);
        }
        else
        {
          DanceLog.b("GLFrameImage", "updateGLFrameImageCache[Error]newImage=" + localGLImage1 + " oldImage=" + localGLImage2 + str);
          if (localGLImage1 != null) {
            localGLImage1.a();
          }
        }
      }
      paramHashMap.clear();
    }
  }
  
  public static void ai_()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (localObject != null) {
        ((GLImage)localObject).a();
      }
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    DanceLog.b("GLFrameImage", "clearTextureCache");
  }
  
  private static void b(boolean paramBoolean)
  {
    Object localObject1 = new ArrayList(50);
    Object localObject2 = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      GLImage localGLImage = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localGLImage != null)
      {
        if (localGLImage.b()) {
          if (localGLImage.a())
          {
            localGLImage.a();
            jdField_a_of_type_JavaUtilHashMap.put(str, null);
            ((ArrayList)localObject1).add(str);
          }
          else if (paramBoolean)
          {
            localGLImage.a();
            jdField_a_of_type_JavaUtilHashMap.put(str, null);
          }
        }
      }
      else {
        DanceLog.b("GLFrameImage", "temporaryReleaseTextureCache[Error] image=null key=" + str);
      }
    }
    DanceLog.b("GLFrameImage", "temporaryReleaseTextureCache[clear boyFilter] size=" + ((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
    }
    DanceLog.b("GLFrameImage", "temporaryReleaseTextureCache boyFilterName=" + ResourceManager.a().a());
    i();
  }
  
  public static void f()
  {
    b(true);
  }
  
  public static void g()
  {
    DanceLog.b("GLFrameImage", "reloadTextureCache[begin]");
    TrAsyncTextureLoad.a().c();
    i();
    b(false);
    j();
    i();
    DanceLog.b("GLFrameImage", "reloadTextureCache[end]");
  }
  
  public static void h()
  {
    DanceLog.b("GLFrameImage", "oncePreloadBoyFilterPrivateResource[begin]");
    Map localMap = ResourceManager.a().a();
    Object localObject1 = localMap.keySet();
    if (((Set)localObject1).size() <= 0) {
      return;
    }
    Iterator localIterator1 = ((Set)localObject1).iterator();
    while (localIterator1.hasNext())
    {
      localObject1 = (ResourceManager.Posture)localMap.get((String)localIterator1.next());
      if ((((ResourceManager.Posture)localObject1).a != null) && (((ResourceManager.Posture)localObject1).a.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        HashMap localHashMap = new HashMap();
        Iterator localIterator2 = ((ResourceManager.Posture)localObject1).a.iterator();
        Object localObject3 = null;
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = localObject3;
            if (localArrayList.size() > 0) {
              localObject2 = (Bitmap)localArrayList.get(0);
            }
          }
          localObject3 = FileUtils.a(str, false, (Bitmap)localObject2);
          localObject1 = localObject2;
          Object localObject4 = localObject3;
          if (localObject3 == null)
          {
            if (localObject2 == null) {
              break label257;
            }
            localArrayList.remove(localObject2);
            ((Bitmap)localObject2).recycle();
            localObject4 = FileUtils.a(str, false);
            localObject1 = null;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (localObject4 == null) {
              break;
            }
            localObject2 = new GLImage(true, true);
            ((GLImage)localObject2).a((Bitmap)localObject4, false);
            localHashMap.put(str, localObject2);
            if (localObject1 != null) {
              break label271;
            }
            localArrayList.add(localObject4);
            localObject3 = localObject1;
            break;
            label257:
            DanceLog.b("GLFrameImage", "oncePreloadBoyFilterPrivateResource error");
            localObject1 = localObject2;
            localObject4 = localObject3;
          }
          label271:
          ((Bitmap)localObject4).recycle();
          localObject3 = localObject1;
        }
        if (localObject3 != null)
        {
          ((Bitmap)localObject3).recycle();
          localArrayList.remove(localObject3);
        }
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Bitmap)((Iterator)localObject1).next()).recycle();
        }
        localArrayList.clear();
        TrAsyncTextureLoad.a().a(localHashMap);
      }
    }
    DanceLog.b("GLFrameImage", "oncePreloadBoyFilterPrivateResource[end]");
  }
  
  private static void i()
  {
    DanceLog.b("GLFrameImage", "printTextureCache[Begin]......................");
    Object localObject = jdField_a_of_type_JavaUtilHashMap.keySet();
    DanceLog.b("GLFrameImage", "printTextureCache size=" + ((Set)localObject).size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      GLImage localGLImage = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localGLImage != null) {
        DanceLog.b("GLFrameImage", "printTextureCache path=" + str + " texture=" + localGLImage.a() + " enableRelease=" + localGLImage.b() + " isBoy=" + localGLImage.a());
      } else {
        DanceLog.b("GLFrameImage", "printTextureCache path=" + str + " Released[noValue]");
      }
    }
    DanceLog.b("GLFrameImage", "printTextureCache[End]......................");
  }
  
  private static void j()
  {
    DanceLog.b("GLFrameImage", "reloadReleaseDanceStageTexture[begin]");
    Set localSet = jdField_a_of_type_JavaUtilHashMap.keySet();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((GLImage)jdField_a_of_type_JavaUtilHashMap.get(str) == null)
      {
        GLImage localGLImage = new GLImage(true);
        localGLImage.a(str);
        jdField_a_of_type_JavaUtilHashMap.put(str, localGLImage);
      }
    }
    DanceLog.b("GLFrameImage", "reloadReleaseDanceStageTexture[end] loadedSize=" + localSet.size());
  }
  
  public int a()
  {
    if (this.d)
    {
      this.jdField_c_of_type_Int = ((int)((float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_b_of_type_Float));
      if (this.jdField_b_of_type_Int != 1) {
        break label65;
      }
      if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        this.jdField_c_of_type_Int = 0;
      }
    }
    for (;;)
    {
      return this.jdField_c_of_type_Int;
      label65:
      if (this.jdField_b_of_type_Int == 0) {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 2 - this.jdField_c_of_type_Int);
          if (this.jdField_c_of_type_Int <= 0)
          {
            this.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
            this.jdField_c_of_type_Int = 0;
          }
        }
        else if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_c_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
          if (this.jdField_c_of_type_Int > 0)
          {
            this.jdField_c_of_type_Boolean = true;
          }
          else
          {
            this.jdField_c_of_type_Boolean = false;
            this.jdField_c_of_type_Int = 0;
          }
        }
      }
    }
  }
  
  public GLImage a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      return (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
    }
    DanceLog.b("GLFrameImage", "getImageSize");
    return null;
  }
  
  public GLImage a(int paramInt)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 0)) && ((GLImage)jdField_a_of_type_JavaUtilHashMap.get(str) == null))
    {
      GLImage localGLImage = new GLImage(this.e, this.jdField_a_of_type_Boolean);
      localGLImage.a(str);
      jdField_a_of_type_JavaUtilHashMap.put(str, localGLImage);
    }
    DanceLog.b("GLFrameImage", "getImageByIndex");
    return (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      Object localObject1;
      Object localObject2;
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!((String)localObject2).equals("")) && ((GLImage)jdField_a_of_type_JavaUtilHashMap.get(localObject2) == null))
          {
            GLImage localGLImage = new GLImage(this.e, this.jdField_a_of_type_Boolean);
            localGLImage.a((String)localObject2);
            jdField_a_of_type_JavaUtilHashMap.put(localObject2, localGLImage);
          }
        }
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localObject1 != null) && (!((String)localObject1).equals("")) && ((GLImage)jdField_a_of_type_JavaUtilHashMap.get(localObject1) == null))
        {
          localObject2 = new GLImage(this.e, this.jdField_a_of_type_Boolean);
          ((GLImage)localObject2).a((String)localObject1);
          jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      this.jdField_b_of_type_Boolean = true;
    }
    DanceLog.b("GLFrameImage", "initAnimationFrame");
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c()
  {
    if (!this.d)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_c_of_type_Int = 0;
      this.d = true;
    }
  }
  
  public final void c(int paramInt)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    GLImage localGLImage;
    if (this.jdField_a_of_type_Int == 0)
    {
      localGLImage = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localGLImage == null) {
        if ((str != null) && (!str.equals("")))
        {
          localGLImage = new GLImage(this.e, this.jdField_a_of_type_Boolean);
          localGLImage.a(str);
          jdField_a_of_type_JavaUtilHashMap.put(str, localGLImage);
          this.f = localGLImage.a();
        }
      }
    }
    for (;;)
    {
      DanceLog.b("GLFrameImage", "setCurrentImage");
      return;
      this.f = localGLImage.a();
      continue;
      if (this.jdField_a_of_type_Int == 1)
      {
        localGLImage = (GLImage)jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localGLImage == null)
        {
          if ((str != null) && (!str.equals("")))
          {
            localGLImage = new GLImage(this.e, this.jdField_a_of_type_Boolean);
            localGLImage.a(str);
            jdField_a_of_type_JavaUtilHashMap.put(str, localGLImage);
            this.f = localGLImage.a();
          }
        }
        else {
          this.f = localGLImage.a();
        }
      }
    }
  }
  
  public void d()
  {
    super.d();
    this.d = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_b_of_type_Int = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage
 * JD-Core Version:    0.7.0.1
 */