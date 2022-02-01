package com.tencent.mobileqq.troop.avatar;

import android.graphics.Bitmap;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.util.Utils;
import java.util.List;
import java.util.Set;

public class AvatarInfo
{
  public static String a = "-5";
  public static int b = -5;
  public String c;
  public String d;
  public int e;
  public int f;
  public boolean g;
  public boolean h;
  public Bitmap i;
  public boolean j;
  public boolean k;
  public String l;
  public int m = 0;
  public long n;
  
  public static final AvatarInfo a(TroopClipPic paramTroopClipPic, Set<String> paramSet)
  {
    AvatarInfo localAvatarInfo = new AvatarInfo();
    localAvatarInfo.d = paramTroopClipPic.id;
    localAvatarInfo.l = paramTroopClipPic.clipInfo;
    localAvatarInfo.m = paramTroopClipPic.type;
    localAvatarInfo.e = 1;
    if (paramSet != null) {
      localAvatarInfo.j = paramSet.contains(paramTroopClipPic.id);
    }
    return localAvatarInfo;
  }
  
  public static final boolean a(List<AvatarInfo> paramList1, List<AvatarInfo> paramList2)
  {
    if (paramList1 == paramList2) {
      return true;
    }
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if (paramList1.size() != paramList2.size()) {
        return false;
      }
      int i1 = 0;
      while (i1 < paramList1.size())
      {
        if (!((AvatarInfo)paramList1.get(i1)).equals(paramList2.get(i1))) {
          return false;
        }
        i1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof AvatarInfo)) {
        return false;
      }
      paramObject = (AvatarInfo)paramObject;
      bool1 = bool2;
      if (Utils.a(this.d, paramObject.d))
      {
        bool1 = bool2;
        if (Utils.a(this.c, paramObject.c))
        {
          bool1 = bool2;
          if (this.e == paramObject.e)
          {
            bool1 = bool2;
            if (this.g == paramObject.g)
            {
              bool1 = bool2;
              if (this.j == paramObject.j)
              {
                bool1 = bool2;
                if (this.k == paramObject.k)
                {
                  bool1 = bool2;
                  if (Utils.a(this.l, paramObject.l))
                  {
                    bool1 = bool2;
                    if (this.m == paramObject.m)
                    {
                      bool1 = bool2;
                      if (this.n == paramObject.n) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvatarInfo=[");
    localStringBuilder.append("seq");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ");
    localStringBuilder.append("fromType");
    localStringBuilder.append("=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append("type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" ");
    localStringBuilder.append("isUploading");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append("isVerifying");
    localStringBuilder.append("=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append("clipInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" ");
    localStringBuilder.append("ts");
    localStringBuilder.append("=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" ");
    localStringBuilder.append("localFile");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.AvatarInfo
 * JD-Core Version:    0.7.0.1
 */