package com.tencent.mobileqq.wink.pick.album.data;

import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleAlbumListPart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AlbumSelectionData
{
  private static AlbumSelectionData a;
  private HashMap<Integer, ArrayList<Long>> b;
  private String c = "";
  
  private AlbumSelectionData()
  {
    d();
  }
  
  public static AlbumSelectionData a()
  {
    if (a == null) {
      a = new AlbumSelectionData();
    }
    return a;
  }
  
  private void a(long paramLong)
  {
    Map.Entry localEntry;
    Object localObject;
    do
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
          } while (localEntry == null);
          localObject = (ArrayList)localEntry.getValue();
        } while (localObject == null);
        localObject = ((ArrayList)localObject).iterator();
      }
    } while (((Long)((Iterator)localObject).next()).longValue() != paramLong);
    ((ArrayList)localEntry.getValue()).remove(Long.valueOf(paramLong));
  }
  
  public static void b()
  {
    a = null;
  }
  
  public void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = this.b;
    if ((localHashMap != null) && (localHashMap.get(Integer.valueOf(paramInt)) != null))
    {
      if (this.b.get(Integer.valueOf(4)) == null) {
        return;
      }
      if (paramBoolean)
      {
        ((ArrayList)this.b.get(Integer.valueOf(paramInt))).add(Long.valueOf(paramLong));
        if (this.c.equals(WinkCircleAlbumListPart.b)) {
          ((ArrayList)this.b.get(Integer.valueOf(4))).add(Long.valueOf(paramLong));
        }
      }
      else
      {
        if (this.c.equals(WinkCircleAlbumListPart.b)) {
          ((ArrayList)this.b.get(Integer.valueOf(4))).remove(Long.valueOf(paramLong));
        }
        a(paramLong);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public HashMap<Integer, ArrayList<Long>> c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.b = new AlbumSelectionData.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.data.AlbumSelectionData
 * JD-Core Version:    0.7.0.1
 */