package dualsim.common;

import android.content.Context;
import java.util.ArrayList;

public abstract interface ISimInterface
{
  public static final int DUAL_SIM_CARD_A = 0;
  public static final int DUAL_SIM_CARD_B = 1;
  public static final int DUAL_SIM_CARD_DEFAULT_VALUE = -1;
  
  public abstract int checkSpecialPermission(Context paramContext, int paramInt);
  
  public abstract boolean fetchSoluAndSave();
  
  public abstract boolean fetchSoluAndSaveSafely();
  
  public abstract int getActiveDataTrafficSimSlot(Context paramContext);
  
  public abstract ArrayList<Integer> getAvailableSimSlotsList(Context paramContext);
  
  public abstract String getSlotIMSI(int paramInt, Context paramContext);
  
  public abstract boolean isAdapterFetchSuccessAfterStartup();
  
  public abstract boolean isDualSimAdapter();
  
  public abstract boolean isDualSimCards();
  
  public abstract boolean isInitFinished();
  
  public abstract boolean isPermInstalledPackagesWarning();
  
  public abstract boolean isPermLocationWarning();
  
  public abstract boolean isSingleSimCard();
  
  public abstract boolean reFetchAdapterIfNeed(boolean paramBoolean);
  
  public abstract void registerInitCallback(ISimInterface.IDualSimInitCallback paramIDualSimInitCallback);
  
  public abstract void unRegisterInitCallback(ISimInterface.IDualSimInitCallback paramIDualSimInitCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dualsim.common.ISimInterface
 * JD-Core Version:    0.7.0.1
 */