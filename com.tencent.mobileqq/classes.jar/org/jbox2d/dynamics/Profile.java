package org.jbox2d.dynamics;

import java.util.List;

public class Profile
{
  public float broadphase;
  public float collide;
  public float solve;
  public float solveInit;
  public float solvePosition;
  public float solveTOI;
  public float solveVelocity;
  public float step;
  
  public void toDebugStrings(List<String> paramList)
  {
    paramList.add("Profile:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" step: ");
    localStringBuilder.append(this.step);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("  collide: ");
    localStringBuilder.append(this.collide);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("  solve: ");
    localStringBuilder.append(this.solve);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("   solveInit: ");
    localStringBuilder.append(this.solveInit);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("   solveVelocity: ");
    localStringBuilder.append(this.solveVelocity);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("   solvePosition: ");
    localStringBuilder.append(this.solvePosition);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("   broadphase: ");
    localStringBuilder.append(this.broadphase);
    paramList.add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("  solveTOI: ");
    localStringBuilder.append(this.solveTOI);
    paramList.add(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.Profile
 * JD-Core Version:    0.7.0.1
 */