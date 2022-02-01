package com.tencent.mobileqq.troop.honor;

import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import java.util.Comparator;

final class TroopHonorAIOUtils$2
  implements Comparator<TroopHonor>
{
  public int a(TroopHonor paramTroopHonor1, TroopHonor paramTroopHonor2)
  {
    if (paramTroopHonor1.d < paramTroopHonor2.d) {
      return -1;
    }
    if (paramTroopHonor1.d > paramTroopHonor2.d) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils.2
 * JD-Core Version:    0.7.0.1
 */