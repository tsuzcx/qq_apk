package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import java.util.ArrayList;
import java.util.List;

public class DataUtils
{
  public static AIOFilePicData a(AIOFilePictureData paramAIOFilePictureData)
  {
    AIOFilePicData localAIOFilePicData = new AIOFilePicData();
    localAIOFilePicData.L = paramAIOFilePictureData.a;
    localAIOFilePicData.M = paramAIOFilePictureData.b;
    localAIOFilePicData.N = paramAIOFilePictureData.c;
    localAIOFilePicData.O = paramAIOFilePictureData.d;
    localAIOFilePicData.P = paramAIOFilePictureData.e;
    localAIOFilePicData.Q = paramAIOFilePictureData.f;
    localAIOFilePicData.R = paramAIOFilePictureData.g;
    localAIOFilePicData.b = paramAIOFilePictureData.j;
    localAIOFilePicData.c = paramAIOFilePictureData.k;
    localAIOFilePicData.d = paramAIOFilePictureData.l;
    localAIOFilePicData.e = paramAIOFilePictureData.m;
    localAIOFilePicData.f = paramAIOFilePictureData.n;
    localAIOFilePicData.p = paramAIOFilePictureData.u;
    localAIOFilePicData.k = paramAIOFilePictureData.r;
    localAIOFilePicData.l = paramAIOFilePictureData.s;
    localAIOFilePicData.n = paramAIOFilePictureData.t;
    localAIOFilePicData.r = paramAIOFilePictureData.v;
    localAIOFilePicData.t = paramAIOFilePictureData.w;
    return localAIOFilePicData;
  }
  
  public static com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData a(com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData paramAIOFileVideoData)
  {
    com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData localAIOFileVideoData = new com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData();
    localAIOFileVideoData.L = paramAIOFileVideoData.a;
    localAIOFileVideoData.M = paramAIOFileVideoData.b;
    localAIOFileVideoData.N = paramAIOFileVideoData.c;
    localAIOFileVideoData.O = paramAIOFileVideoData.d;
    localAIOFileVideoData.P = paramAIOFileVideoData.e;
    localAIOFileVideoData.Q = paramAIOFileVideoData.f;
    localAIOFileVideoData.R = paramAIOFileVideoData.g;
    localAIOFileVideoData.b = paramAIOFileVideoData.k;
    localAIOFileVideoData.a = paramAIOFileVideoData.j;
    localAIOFileVideoData.c = paramAIOFileVideoData.l;
    localAIOFileVideoData.d = paramAIOFileVideoData.m;
    localAIOFileVideoData.e = paramAIOFileVideoData.n;
    localAIOFileVideoData.f = paramAIOFileVideoData.o;
    return localAIOFileVideoData;
  }
  
  public static AIOImageData a(AIOPictureData paramAIOPictureData)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.L = paramAIOPictureData.a;
    localAIOImageData.M = paramAIOPictureData.b;
    localAIOImageData.N = paramAIOPictureData.c;
    localAIOImageData.O = paramAIOPictureData.d;
    localAIOImageData.P = paramAIOPictureData.e;
    localAIOImageData.Q = paramAIOPictureData.f;
    localAIOImageData.R = paramAIOPictureData.g;
    localAIOImageData.a = paramAIOPictureData.j;
    localAIOImageData.b = paramAIOPictureData.k;
    localAIOImageData.c = paramAIOPictureData.l;
    localAIOImageData.d = paramAIOPictureData.m;
    localAIOImageData.n = paramAIOPictureData.r;
    localAIOImageData.o = paramAIOPictureData.s;
    localAIOImageData.p = paramAIOPictureData.t;
    localAIOImageData.h = paramAIOPictureData.q;
    localAIOImageData.r = paramAIOPictureData.v;
    localAIOImageData.t = paramAIOPictureData.w;
    localAIOImageData.w = paramAIOPictureData.x;
    localAIOImageData.q = paramAIOPictureData.u;
    localAIOImageData.A = paramAIOPictureData.y;
    localAIOImageData.B = paramAIOPictureData.z;
    localAIOImageData.C = paramAIOPictureData.A;
    localAIOImageData.D = paramAIOPictureData.B;
    localAIOImageData.E = paramAIOPictureData.C;
    localAIOImageData.F = paramAIOPictureData.D;
    localAIOImageData.G = paramAIOPictureData.E;
    localAIOImageData.H = paramAIOPictureData.F;
    localAIOImageData.I = paramAIOPictureData.G;
    localAIOImageData.J = paramAIOPictureData.H;
    localAIOImageData.K = paramAIOPictureData.I;
    return localAIOImageData;
  }
  
  public static AIORichMediaData a(AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData localAIOFileVideoData = null;
    if (paramAIOBrowserBaseData == null) {
      return null;
    }
    if ((paramAIOBrowserBaseData instanceof AIOPictureData)) {
      return a((AIOPictureData)paramAIOBrowserBaseData);
    }
    if ((paramAIOBrowserBaseData instanceof AIOFilePictureData)) {
      return a((AIOFilePictureData)paramAIOBrowserBaseData);
    }
    if ((paramAIOBrowserBaseData instanceof AIOVideoData)) {
      return a((AIOVideoData)paramAIOBrowserBaseData);
    }
    if ((paramAIOBrowserBaseData instanceof com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData)) {
      localAIOFileVideoData = a((com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData)paramAIOBrowserBaseData);
    }
    return localAIOFileVideoData;
  }
  
  public static AIOShortVideoData a(AIOVideoData paramAIOVideoData)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.L = paramAIOVideoData.a;
    localAIOShortVideoData.M = paramAIOVideoData.b;
    localAIOShortVideoData.N = paramAIOVideoData.c;
    localAIOShortVideoData.O = paramAIOVideoData.d;
    localAIOShortVideoData.P = paramAIOVideoData.e;
    localAIOShortVideoData.Q = paramAIOVideoData.f;
    localAIOShortVideoData.R = paramAIOVideoData.g;
    localAIOShortVideoData.a = paramAIOVideoData.j;
    localAIOShortVideoData.b = paramAIOVideoData.k;
    localAIOShortVideoData.c = paramAIOVideoData.l;
    localAIOShortVideoData.d = paramAIOVideoData.m;
    localAIOShortVideoData.g = paramAIOVideoData.p;
    localAIOShortVideoData.h = paramAIOVideoData.q;
    localAIOShortVideoData.i = paramAIOVideoData.r;
    localAIOShortVideoData.l = paramAIOVideoData.s;
    localAIOShortVideoData.p = paramAIOVideoData.t;
    localAIOShortVideoData.r = paramAIOVideoData.z;
    localAIOShortVideoData.s = paramAIOVideoData.A;
    return localAIOShortVideoData;
  }
  
  public static AIOBrowserBaseData a(AIORichMediaData paramAIORichMediaData)
  {
    com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData localAIOFileVideoData = null;
    if (paramAIORichMediaData == null) {
      return null;
    }
    if ((paramAIORichMediaData instanceof AIOImageData)) {
      return a((AIOImageData)paramAIORichMediaData);
    }
    if ((paramAIORichMediaData instanceof AIOFilePicData)) {
      return a((AIOFilePicData)paramAIORichMediaData);
    }
    if ((paramAIORichMediaData instanceof AIOShortVideoData)) {
      return a((AIOShortVideoData)paramAIORichMediaData);
    }
    if ((paramAIORichMediaData instanceof com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData)) {
      localAIOFileVideoData = a((com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData)paramAIORichMediaData);
    }
    return localAIOFileVideoData;
  }
  
  public static AIOFilePictureData a(AIOFilePicData paramAIOFilePicData)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.a = paramAIOFilePicData.L;
    localAIOFilePictureData.b = paramAIOFilePicData.M;
    localAIOFilePictureData.c = paramAIOFilePicData.N;
    localAIOFilePictureData.d = paramAIOFilePicData.O;
    localAIOFilePictureData.e = paramAIOFilePicData.P;
    localAIOFilePictureData.f = paramAIOFilePicData.Q;
    localAIOFilePictureData.g = paramAIOFilePicData.R;
    localAIOFilePictureData.h = paramAIOFilePicData.S;
    localAIOFilePictureData.i = paramAIOFilePicData.T;
    localAIOFilePictureData.j = paramAIOFilePicData.b;
    localAIOFilePictureData.k = paramAIOFilePicData.c;
    localAIOFilePictureData.l = paramAIOFilePicData.d;
    localAIOFilePictureData.m = paramAIOFilePicData.e;
    localAIOFilePictureData.n = paramAIOFilePicData.f;
    localAIOFilePictureData.u = paramAIOFilePicData.p;
    localAIOFilePictureData.r = paramAIOFilePicData.k;
    localAIOFilePictureData.s = paramAIOFilePicData.l;
    localAIOFilePictureData.t = paramAIOFilePicData.n;
    localAIOFilePictureData.v = paramAIOFilePicData.r;
    localAIOFilePictureData.w = paramAIOFilePicData.t;
    localAIOFilePictureData.x = paramAIOFilePicData.u;
    localAIOFilePictureData.y = paramAIOFilePicData.v;
    localAIOFilePictureData.z = paramAIOFilePicData.w;
    return localAIOFilePictureData;
  }
  
  public static com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData a(com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData paramAIOFileVideoData)
  {
    com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData localAIOFileVideoData = new com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData();
    localAIOFileVideoData.a = paramAIOFileVideoData.L;
    localAIOFileVideoData.b = paramAIOFileVideoData.M;
    localAIOFileVideoData.c = paramAIOFileVideoData.N;
    localAIOFileVideoData.d = paramAIOFileVideoData.O;
    localAIOFileVideoData.e = paramAIOFileVideoData.P;
    localAIOFileVideoData.f = paramAIOFileVideoData.Q;
    localAIOFileVideoData.g = paramAIOFileVideoData.R;
    localAIOFileVideoData.h = paramAIOFileVideoData.S;
    localAIOFileVideoData.i = paramAIOFileVideoData.T;
    localAIOFileVideoData.k = paramAIOFileVideoData.b;
    localAIOFileVideoData.j = paramAIOFileVideoData.a;
    localAIOFileVideoData.l = paramAIOFileVideoData.c;
    localAIOFileVideoData.m = paramAIOFileVideoData.d;
    localAIOFileVideoData.n = paramAIOFileVideoData.e;
    localAIOFileVideoData.o = paramAIOFileVideoData.f;
    localAIOFileVideoData.v = paramAIOFileVideoData.o;
    localAIOFileVideoData.B = paramAIOFileVideoData.r;
    localAIOFileVideoData.C = paramAIOFileVideoData.s;
    localAIOFileVideoData.D = paramAIOFileVideoData.t;
    localAIOFileVideoData.E = paramAIOFileVideoData.u;
    localAIOFileVideoData.F = paramAIOFileVideoData.v;
    return localAIOFileVideoData;
  }
  
  public static AIOPictureData a(AIOImageData paramAIOImageData)
  {
    AIOPictureData localAIOPictureData = new AIOPictureData();
    localAIOPictureData.a = paramAIOImageData.L;
    localAIOPictureData.b = paramAIOImageData.M;
    localAIOPictureData.c = paramAIOImageData.N;
    localAIOPictureData.d = paramAIOImageData.O;
    localAIOPictureData.e = paramAIOImageData.P;
    localAIOPictureData.f = paramAIOImageData.Q;
    localAIOPictureData.g = paramAIOImageData.R;
    localAIOPictureData.h = paramAIOImageData.S;
    localAIOPictureData.i = paramAIOImageData.T;
    localAIOPictureData.j = paramAIOImageData.a;
    localAIOPictureData.k = paramAIOImageData.b;
    localAIOPictureData.l = paramAIOImageData.c;
    localAIOPictureData.m = paramAIOImageData.d;
    localAIOPictureData.r = paramAIOImageData.n;
    localAIOPictureData.s = paramAIOImageData.o;
    localAIOPictureData.t = paramAIOImageData.p;
    localAIOPictureData.q = paramAIOImageData.h;
    localAIOPictureData.v = paramAIOImageData.r;
    localAIOPictureData.w = paramAIOImageData.t;
    localAIOPictureData.x = paramAIOImageData.w;
    localAIOPictureData.u = paramAIOImageData.q;
    localAIOPictureData.y = paramAIOImageData.A;
    localAIOPictureData.z = paramAIOImageData.B;
    localAIOPictureData.A = paramAIOImageData.C;
    localAIOPictureData.B = paramAIOImageData.D;
    localAIOPictureData.C = paramAIOImageData.E;
    localAIOPictureData.D = paramAIOImageData.F;
    localAIOPictureData.E = paramAIOImageData.G;
    localAIOPictureData.F = paramAIOImageData.H;
    localAIOPictureData.G = paramAIOImageData.I;
    localAIOPictureData.H = paramAIOImageData.J;
    localAIOPictureData.I = paramAIOImageData.K;
    return localAIOPictureData;
  }
  
  public static AIOVideoData a(AIOShortVideoData paramAIOShortVideoData)
  {
    AIOVideoData localAIOVideoData = new AIOVideoData();
    localAIOVideoData.a = paramAIOShortVideoData.L;
    localAIOVideoData.b = paramAIOShortVideoData.M;
    localAIOVideoData.c = paramAIOShortVideoData.N;
    localAIOVideoData.d = paramAIOShortVideoData.O;
    localAIOVideoData.e = paramAIOShortVideoData.P;
    localAIOVideoData.f = paramAIOShortVideoData.Q;
    localAIOVideoData.g = paramAIOShortVideoData.R;
    localAIOVideoData.h = paramAIOShortVideoData.S;
    localAIOVideoData.i = paramAIOShortVideoData.T;
    localAIOVideoData.j = paramAIOShortVideoData.a;
    localAIOVideoData.k = paramAIOShortVideoData.b;
    localAIOVideoData.l = paramAIOShortVideoData.c;
    localAIOVideoData.m = paramAIOShortVideoData.d;
    localAIOVideoData.p = paramAIOShortVideoData.g;
    localAIOVideoData.q = paramAIOShortVideoData.h;
    localAIOVideoData.r = paramAIOShortVideoData.i;
    localAIOVideoData.s = paramAIOShortVideoData.l;
    localAIOVideoData.t = paramAIOShortVideoData.p;
    localAIOVideoData.z = paramAIOShortVideoData.r;
    localAIOVideoData.A = paramAIOShortVideoData.s;
    return localAIOVideoData;
  }
  
  public static AIOBrowserBaseData[] a(AIORichMediaData[] paramArrayOfAIORichMediaData)
  {
    if (paramArrayOfAIORichMediaData == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfAIORichMediaData.length)
    {
      AIOBrowserBaseData localAIOBrowserBaseData = a(paramArrayOfAIORichMediaData[i]);
      if (localAIOBrowserBaseData != null) {
        localArrayList.add(localAIOBrowserBaseData);
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      return (AIOBrowserBaseData[])localArrayList.toArray(new AIOBrowserBaseData[localArrayList.size()]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.DataUtils
 * JD-Core Version:    0.7.0.1
 */