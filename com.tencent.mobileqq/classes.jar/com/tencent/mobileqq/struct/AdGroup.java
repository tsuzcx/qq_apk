package com.tencent.mobileqq.struct;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdGroup
  implements Serializable
{
  public int currentIndex = 0;
  public List<AdData> listAD = new LinkedList();
  
  public boolean add(AdData paramAdData)
  {
    boolean bool = true;
    Object localObject;
    if ((paramAdData != null) && (paramAdData.jump_url != null) && (paramAdData.jump_url.length() > 0))
    {
      localObject = this.listAD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdData localAdData = (AdData)((Iterator)localObject).next();
        if (paramAdData.jump_url.equals(localAdData.jump_url))
        {
          i = 1;
          break label78;
        }
      }
      int i = 0;
      label78:
      if (i == 0)
      {
        this.listAD.add(paramAdData);
        break label98;
      }
    }
    bool = false;
    label98:
    if ((QLog.isColorLevel()) && (paramAdData != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add AD=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" pos=");
      ((StringBuilder)localObject).append(paramAdData.position);
      ((StringBuilder)localObject).append(" jumpUrl=");
      ((StringBuilder)localObject).append(paramAdData.jump_url);
      QLog.d("AdGroup", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.struct.AdGroup
 * JD-Core Version:    0.7.0.1
 */